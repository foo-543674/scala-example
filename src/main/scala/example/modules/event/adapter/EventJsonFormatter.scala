package example.modules.event.adapter

//#json-formats
import spray.json.DefaultJsonProtocol
import example.modules.event.domain.{Event, EventId, Held}
import example.modules.event.usecases.{CreateEventParameter}
import example.common.domain.Ulid
import example.common.adapter.{DateTimeJsonProtocol}

object EventJsonFormats {
  // import the default encoders for primitive types (Int, String, Lists etc)
  import DefaultJsonProtocol._
  import DateTimeJsonProtocol.DateTimeJsonFormat

  implicit val ulidJsonFormat = jsonFormat1(Ulid)
  implicit val eventIdJsonFormat = jsonFormat1(EventId)
  implicit val heldJsonFormat = jsonFormat1(Held)
  implicit val eventJsonFormat = jsonFormat4(Event)
  implicit val createEventParameterJsonFormat = jsonFormat3(CreateEventParameter)
}
//#json-formats
