package example.domain.event

import org.joda.time.{DateTime}

case class Held(
    ownerId: EventId,
    heldAt: DateTime
)
