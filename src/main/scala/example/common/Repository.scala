package example.common

import scala.util.Try
import scala.collection.immutable.Seq

trait Repository[I <: Identifer[_], E <: Entity[I], F[_]] {
  def findById(id: I): F[Option[E]]
  def list(entity: E): F[Seq[E]]
  def store(entity: E): F[Try[E]]
}
