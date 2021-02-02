package example.usecases.event

import example.domain.event.{Event, EventId, EventRepository, Held}
import example.common.{IdGenerator, EmptyIdentifer}
import scala.util.Try

trait CreateEventUsecase[F[_]] {
  def save(
      repository: EventRepository[F],
      param: CreateEventParameter,
      idGenerator: IdGenerator[EventId]
  ): F[Try[Event]] = repository.store(
    new Event(
      idGenerator.generate,
      param.name,
      new Held(param.heldAt),
      param.description
    )
  )
}
