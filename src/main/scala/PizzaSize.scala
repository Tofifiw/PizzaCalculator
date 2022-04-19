
/*object PizzaSize extends Enumeration {

  val Small = Value("Small")
  val Medium = Value("Medium")
  val Large = Value("Large")
}*/


sealed abstract class PizzaSize (val description: String)

object PizzaSize {

  def fromString(value: String): Option[PizzaSize] = {
    List(Small, Medium, Large).find(_.toString == value)
  }

}

case object Small extends PizzaSize("Small")
case object Medium extends PizzaSize("Medium")
case object Large extends PizzaSize("Large")
