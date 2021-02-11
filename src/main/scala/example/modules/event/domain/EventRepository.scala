package example.modules.event.domain

import example.common.domain.Repository

trait EventRepository[F[_]] extends Repository[EventId, Event, F]