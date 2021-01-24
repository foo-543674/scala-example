package example.common

import scala.util.Try
import scala.collection.immutable.Seq

trait Repository[ID <: Identifer[_], Entity <: Entity[ID], F[_]] {
  def findById(id: EventId): F[Option[Entity]]
  def list(entity: Entity): F[Seq[Entity]]
  def store(entity: Entity): F[Try[Entity]]
}
