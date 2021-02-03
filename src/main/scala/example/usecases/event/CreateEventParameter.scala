package example.usecases.event

import org.joda.time.{DateTime}

case class CreateEventParameter(
    name: String,
    heldAt: DateTime,
    description: String
)