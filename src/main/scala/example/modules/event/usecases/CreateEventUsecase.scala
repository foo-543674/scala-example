package example.modules.event.usecases

import example.modules.event.domain.{Event, EventId, EventRepository, Held}
import example.common.domain.{IdGenerator, EmptyIdentifer}
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
