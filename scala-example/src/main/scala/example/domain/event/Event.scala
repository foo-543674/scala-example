package example.domain.event

import org.joda.time.{DateTime}

case class Event(
    id: EventId,
    name: String,
    held: Held,
    description: String
)