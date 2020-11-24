package example.common

trait EmptyIdentifer extends Identifer[Nothing] {
    def value: Nothing = throw new NoSuchElementException

    
}