package example.usecases.event

import example.domain.event.{Event, EventId, EventRepository, Held}
import example.common.{IdGenerator, EmptyIdentifer}
import scala.util.Try

trait CreateEventUsecase[F[_]] {
  def getRepository: EventRepository[F]
  def getIdGenerator: IdGenerator[EventId]

  def save(
      param: CreateEventParameter,
  ): F[Try[Event]] = getRepository.store(
    new Event(
      getIdGenerator.generate,
      param.name,
      new Held(param.heldAt),
      param.description
    )
  )
}
