class RectanglePizza extends PizzaType {
  val description: String = "Rectangle Pizza"

  def calculateProduct(quantity: Int, discount: String, size: PizzaSize): Float = {

    size match {
      case Small => if ((quantity > 4) && discount.toUpperCase() == "FreePizza".toUpperCase) quantity * 5.80f * 0.85f else quantity * 5.80f
      case Medium => if ((quantity > 3) && discount.toUpperCase() == "FreePizza".toUpperCase) quantity * 7.25f * 0.80f else quantity * 7.25f
      case Large => if ((quantity > 2) && discount.toUpperCase() == "FreePizza".toUpperCase) quantity * 9.68f * 0.75f else quantity * 9.68f
    }
  }
}
