package example.adapter.events

import example.domain.event.EventRepository
import scala.concurrent.Future
import example.usecases.event.CreateEventUsecase
import example.domain.event.EventIdGenerator
import example.common.IdGenerator
import example.domain.event.EventId

class EventService(
    repository: EventRepository[Future],
    idGenerator: EventIdGenerator
) extends CreateEventUsecase[Future] {
    def getRepository: EventRepository[Future] = repository
    def getIdGenerator: IdGenerator[EventId] = idGenerator
}
