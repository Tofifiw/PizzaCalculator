class RoundPizza extends PizzaType {
  val description: String = "Round Pizza"

  def calculateProduct(quantity: Int, discount: String, size: PizzaSize): Float = {

    size match {
      case Small => if ((quantity > 4) && discount.toUpperCase() == "FreePizza".toUpperCase()) quantity * 4.45f * 0.85f else quantity * 4.45f
      case Medium => if ((quantity > 3) && discount.toUpperCase() == "FreePizza".toUpperCase()) quantity * 6.56f * 0.80f else quantity * 6.56f
      case Large => if ((quantity > 2) && discount.toUpperCase() == "FreePizza".toUpperCase()) quantity * 8.45f * 0.75f else quantity * 8.45f
    }
  }
}
