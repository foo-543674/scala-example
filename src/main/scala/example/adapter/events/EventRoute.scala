package example.adapter.events

import example.domain.event.EventRepository
import scala.concurrent.Future
import akka.actor.typed.ActorSystem
import scala.concurrent.ExecutionContext
import akka.actor.typed.ActorRef
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import example.usecases.event.CreateEventParameter
import akka.actor.typed.scaladsl.AskPattern._
import akka.util.Timeout

class EventRoute(service: ActorRef[EventServiceCommand])(
    implicit val system: ActorSystem[_],
    implicit val executionContext: ExecutionContext
) {

  import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
    private implicit val timeout = Timeout.create(system.settings.config.getDuration("my-app.routes.ask-timeout"))

  import EventJsonFormats._

  var routes: Route =
    pathPrefix("events") {
      concat(
        pathEnd {
          concat(
            post {
              entity(as[CreateEventParameter]) { param =>
                onSuccess(service.ask(CreateEvent(param, _))) { result =>
                  result.map(event => complete(StatusCodes.OK, event))
                    .recover(_ => complete(StatusCodes.InternalServerError))
                }
              }
            }
          )
        }
      )
    }
}
