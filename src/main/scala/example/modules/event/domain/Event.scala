package example.modules.event.domain

import example.common.domain.{Entity}

case class Event(
    id: EventId,
    name: String,
    held: Held,
    description: String
) extends Entity[EventId]