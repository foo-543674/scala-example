package example.modules.event.adapter

import akka.actor.typed.ActorRef
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import scala.collection.immutable
import scala.concurrent.Future
import example.common.domain.{IdGenerator}
import example.modules.event.domain.{Event, EventId, EventIdGenerator, EventRepository}
import example.modules.event.usecases.{CreateEventParameter, CreateEventUsecase}
import scala.util.Try
import scala.concurrent.ExecutionContext

sealed trait EventServiceCommand;
final case class CreateEvent(
    param: CreateEventParameter,
    replyTo: ActorRef[Try[Event]]
) extends EventServiceCommand

class EventService(
    repository: EventRepository[Future],
    idGenerator: EventIdGenerator
)(implicit val executionContext: ExecutionContext)
    extends CreateEventUsecase[Future] {

    def getRepository: EventRepository[Future] = repository
    def getIdGenerator: IdGenerator[EventId] = idGenerator

    def apply(): Behavior[EventServiceCommand] = Behaviors.receiveMessage {
    case CreateEvent(param, replyTo) =>
        save(param).map(result => replyTo ! result)
        Behaviors.same
    }
}
