package example.common

trait Identifier[+T] {
    def value: T

    val isDefined: Boolean = true

    val isEmpty: Boolean = !isDefined

    override def equals(that: Any) = that match {
        case that: Identifer[_] => value == that.value
        case _ => false
    }

    override def hashCode: Int = 29 * value.##
}
