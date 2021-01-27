package example.domain.event

import example.common.Identifer

case class EventId(ulid: String) extends Identifer[String]