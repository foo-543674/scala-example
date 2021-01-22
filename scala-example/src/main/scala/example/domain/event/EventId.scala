package example.domain.event

import example.common.Identifer

case class EventId(value: Long) extends Identifer[Long]