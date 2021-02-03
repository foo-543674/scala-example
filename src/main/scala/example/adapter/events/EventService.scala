package example.adapter.events

import akka.actor.typed.ActorRef
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import scala.collection.immutable
import example.domain.event.EventRepository
import scala.concurrent.Future
import example.usecases.event.CreateEventUsecase
import example.domain.event.EventIdGenerator
import example.common.IdGenerator
import example.domain.event.EventId
import example.usecases.event.CreateEventParameter
import example.domain.event.Event
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
