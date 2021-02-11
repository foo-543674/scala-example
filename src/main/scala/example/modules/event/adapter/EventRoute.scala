package example.modules.event.adapter

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.actor.typed.ActorRef
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.AskPattern._
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.ExecutionContext

import example.modules.event.domain.{Event, EventRepository}
import example.modules.event.usecases.{CreateEventParameter}
import scala.util.Try
import scala.util.Success

class EventRoute(service: ActorRef[EventServiceCommand])(
    implicit val system: ActorSystem[_],
    implicit val executionContext: ExecutionContext,
    implicit val timeout: Timeout
) {

  import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
  import EventJsonFormats._


  val routes =
    pathPrefix("events") {
      pathEnd {
        post {
          entity(as[CreateEventParameter]) { param =>
            onSuccess(service.ask(CreateEvent(param, _))) { result =>
              //TODO: コンパイル失敗しないが、エディタ上で型エラーになってるので調査
              result.map(event => complete((StatusCodes.OK, event)))
                .getOrElse(complete((StatusCodes.InternalServerError)))
            }
          }
        }
      }
    }
}
