package example.common

trait IdGenerator[ID <: Identifier[_]] {
    def generate(): String
}