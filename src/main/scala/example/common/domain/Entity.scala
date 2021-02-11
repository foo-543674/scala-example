package example.common.domain

trait Entity[ID <: Identifer[_]] {
    val id: ID

    override def equals(that: Any) = that match {
        case that: Entity[_] => that.isInstanceOf[this.type] && id == that.id
        case _ => false
    }

    override def hashCode: Int = id.##
}