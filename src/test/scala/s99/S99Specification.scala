package s99

import org.specs2.execute._
import org.specs2.mutable.Specification
import org.specs2.specification.AroundEach

trait S99Specification extends Specification with AroundEach {

  def around[R: AsResult](r: => R): Result = AsResult(r) match {
    case Failure("an implementation is missing", _, _, _) => Pending("TODO")
    case res => res
  }
}
