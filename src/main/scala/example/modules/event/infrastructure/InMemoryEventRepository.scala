package example.modules.event.infrastructure

import scala.concurrent.Future
import example.modules.event.domain.{Event, EventId, EventRepository}
import scala.util.Try
import akka.actor.typed.ActorRef

object InMemoryEventRepository extends EventRepository[Future] {

    sealed trait EventRepositoryCommand
    final case class StoreEvent(entity: Event, replyTo: ActorRef[Event]) extends EventRepositoryCommand
    final case class GetEvent(id: EventId, replyTo: ActorRef[Event]) extends EventRepositoryCommand
    final case class GetEvents(replyTo: ActorRef[Seq[Event]]) extends EventRepositoryCommand


    def findById(id: EventId): Future[Option[Event]] = ???
    def list(entity: Event): Future[Seq[Event]] = ???
    def store(entity: Event): Future[Try[Event]] = ???
}