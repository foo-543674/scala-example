package example.domain.event

import example.common.{IdGenerator, Ulid}
import net.petitviolet.ulid4s.ULID

class EventIdGenerator extends IdGenerator[EventId] {
    def generate(): EventId = new EventId(new Ulid(ULID.generate))
}