package example.modules.event.domain

import example.common.domain.{IdGenerator, Ulid}
import net.petitviolet.ulid4s.ULID

class EventIdGenerator extends IdGenerator[EventId] {
    def generate(): EventId = new EventId(new Ulid(ULID.generate))
}