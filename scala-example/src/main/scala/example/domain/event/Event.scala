package example.domain.event

import example.common._

case class Event(
    id: EventId,
    name: String,
    held: Held,
    description: String
) extends Entity[EventId] {
}