class Calzone extends PizzaType {
  val description: String = "Calzone"

  def calculateProduct(quantity: Int, discount: String, size: PizzaSize): Float = {

    size match {
      case Small => if ((quantity > 5) && discount.toUpperCase() == "FreePizza".toUpperCase()) quantity * 4.50f * 0.85f else quantity * 4.50f
      case Medium => if ((quantity > 4) && discount.toUpperCase() == "FreePizza".toUpperCase()) quantity * 7.25f * 0.85f else quantity * 7.25f
      case Large => if ((quantity > 3) && discount.toUpperCase() == "FreePizza".toUpperCase) quantity * 10.25f * 0.75f else quantity * 10.25f
    }
  }
}
