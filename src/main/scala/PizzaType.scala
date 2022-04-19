trait PizzaTypeTrait {
  val description: String
  def calculateProduct(quantity: Int, discount: String, size: PizzaSize): Float
}

abstract class PizzaType extends PizzaTypeTrait {

}
