package example.usecases.events

import example.domain.event._
import example.common._

class CreateEventUsecase[F[_]](repository: EventRepository[F]) {
    def apply(idGenerator: IdGenerator[EventId]): Try[F[Event]] => {

    }
}