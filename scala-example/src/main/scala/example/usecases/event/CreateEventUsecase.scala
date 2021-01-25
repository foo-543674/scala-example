package example.usecases.event

import example.domain.event.{Event,EventId,EventRepository,Held}
import example.common.{IdGenerator}

class CreateEventUsecase[F[_]](repository: EventRepository[F], idGenerator: IdGenerator[EventId]) {
    def apply(parameter: CreateEventParameter): Try[F[Event]] => {
    }
}