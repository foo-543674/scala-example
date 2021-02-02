package example.common

trait IdGenerator[ID <: Identifer[_]] {
    def generate(): ID
}