package example.common

trait EmptyIdentifer extends Identifer[Nothing] {
    def value: Nothing = throw new NoSuchElementException

    override val isDefined = false

    override def equals(that: Any) = that match {
        case that: EmptyIdentifer => this eq that
        case _ => false
    }

    override def hashCode = 0
}

object EmptyIdentifier extends EmptyIdentifer