package example.common

trait Identifer[+A] {
    def value: A

    override dev equals(that: Any) = that match {
        case that: Identifer[_] => value == that.value
        case _ => false
    }
}
