package example.usecases.event

import example.domain.event.{Event,EventId,EventRepository,Held}
import example.common.{IdGenerator,EmptyIdentifer}
import scala.util.Try

class CreateEventUsecase[F[_]](repository: EventRepository[F], idGenerator: IdGenerator[EventId]) {
}