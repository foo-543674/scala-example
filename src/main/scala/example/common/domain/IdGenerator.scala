package example.common.domain

trait IdGenerator[ID <: Identifer[_]] {
    def generate(): ID
}