package example.modules.event.domain

import example.common.domain.{Ulid, Identifer}

case class EventId(value: Ulid) extends Identifer[Ulid]