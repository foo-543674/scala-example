package example.domain.event

import example.common.Identifer
import example.common.Ulid

case class EventId(value: Ulid) extends Identifer[Ulid]