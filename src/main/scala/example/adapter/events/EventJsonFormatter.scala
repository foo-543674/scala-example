package example.adapter.events

//#json-formats
import spray.json.DefaultJsonProtocol
import example.domain.event.Event
import example.domain.event.EventId
import example.common.Ulid
import example.domain.event.Held
import example.usecases.event.CreateEventParameter

object EventJsonFormats {
  // import the default encoders for primitive types (Int, String, Lists etc)
  import DefaultJsonProtocol._
  import example.adapter.common.DateTimeJsonProtocol.DateTimeJsonFormat

  implicit val ulidJsonFormat = jsonFormat1(Ulid)
  implicit val eventIdJsonFormat = jsonFormat1(EventId)
  implicit val heldJsonFormat = jsonFormat1(Held)
  implicit val eventJsonFormat = jsonFormat4(Event)
  implicit val createEventParameterJsonFormat = jsonFormat3(CreateEventParameter)
}
//#json-formats
