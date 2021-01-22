package example.domain.event

case class EventId(ulid: String) extends Identifer[String]