package example.domain.event

import example.common.Repository

trait EventRepository[F[_]] extends Repository[EventId, Event, F]