package example.common.adapter

import spray.json.DefaultJsonProtocol
import spray.json.RootJsonFormat
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import spray.json.deserializationError
import spray.json.JsValue
import spray.json.JsString

object DateTimeJsonProtocol extends DefaultJsonProtocol {
    implicit object DateTimeJsonFormat extends RootJsonFormat[DateTime] {
        private lazy val format = ISODateTimeFormat.dateTimeNoMillis()

        def write(value: DateTime): JsValue = JsString(format.print(value))
        def read(json: JsValue): DateTime = json match {
            case JsString(value) => format.parseDateTime(value)
            case value => deserializationError(value + " is not datetime string")
        }
    }
}