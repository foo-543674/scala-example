package example.modules.event.infrastructure

import akka.actor.typed.Behavior
import akka.persistence.typed.scaladsl.EventSourcedBehavior
import akka.persistence.typed.PersistenceId

object EventBehavior {
    sealed trait Command
    sealed trait Event
    final case class State()

    def apply(): Behavior[Command] = 
        EventSourcedBehavior[Command, Event, State](
            persistenceId = PersistenceId.ofUniqueId("abc"),
            emptyState = State(),
            commandHandler = (state, cmd) => ???,
            eventHandler = (state, evt) => ???,
        )
}