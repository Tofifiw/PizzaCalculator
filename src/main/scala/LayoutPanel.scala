
import java.awt.Color
import scala.collection.mutable.ArrayBuffer
import scala.swing._

class LayoutPanel extends GridBagPanel{

  val availableFood = ArrayBuffer[PizzaType]()

  // add food here
  availableFood += new RoundPizza
  availableFood += new Calzone
  availableFood += new RectanglePizza

  // article type combo box -------------------

  add(new Label("Food Type"), constraints(0, 0))

  // automatically generate an array for the dropdown list

  val availableFoodDescriptions = ArrayBuffer[String]()

  availableFood.foreach(availableFoodDescriptions += _.description)

  val availableFoodComboBox = new ComboBox(availableFoodDescriptions)
  add(availableFoodComboBox, constraints(1, 0, gridheight = 2))

  // size combo box ---------------------

  add(new Label("Food Size"), constraints(0, 2))
  val sizeComboBox = new ComboBox(Seq("Small", "Medium", "Large"))
  add(sizeComboBox, constraints(1, 2, gridheight = 2))

  // quantity input box --------------------------

  add(new Label("Quantity"), constraints(0, 4))
  val quantityTextField = new TextField(columns = 10)
  quantityTextField.text = "1"
  add(quantityTextField, constraints(1, 4, gridheight = 2))

  // discount input box

  add(new Label("Coupon Code"), constraints(0,6))
  val discountTextField = new TextField(columns = 10)
  discountTextField.text = "NONE"
  add(discountTextField, constraints(1, 6, gridheight = 2))

  // button ------------------------------------

  add(Button("Calculate"){ calculateProduct() }, constraints(0, 8, gridheight = 2, gridwidth = 2, fill=GridBagPanel.Fill.Both, anchor = GridBagPanel.Anchor.Center))

  add(new Label(" "), constraints(0, 10, gridwidth = 2))

  // preview text label

  add(new Label("Preview:"), constraints(0, 11, gridwidth = 2, anchor = GridBagPanel.Anchor.Center))

  // stamp -------------------------------------

  val stampLabel = new Label
  stampLabel.font = Font("System", Font.Bold, 28)
  stampLabel.foreground = Color.black
  stampLabel.horizontalTextPosition = Alignment.Center
  stampLabel.text = s"<html>Money to be paid<br>\n$$0</html>"

  add(stampLabel, constraints(0, 12, gridwidth = 2))

  // methods ----------------------------------------------------------------------

  def calculateProduct() = {

    var quantityEntered = 0
    var discountEntered = " "

    try discountEntered = discountTextField.text
    catch {
      case _ =>
    }


    try quantityEntered = quantityTextField.text.toInt
    catch {
      case _: NumberFormatException =>
    }

    // val postage = availableMailArticles.apply(articleTypeComboBox.selection.index).calculatePostage(weightEntered, destinationComboBox.selection.item)
    // val postage = availableMailArticles.apply(articleTypeComboBox.selection.index).calculatePostage(weightEntered, MailDestination.withName(destinationComboBox.selection.item))
     val food = availableFood.apply(availableFoodComboBox.selection.index).calculateProduct(quantityEntered, discountEntered, PizzaSize.fromString(sizeComboBox.selection.item).get)
     stampLabel.text = f"<html>Money to be paid<br>\n$$$food%1.2f</html>"
  }

  def constraints(x: Int, y: Int,
                  gridwidth: Int = 1, gridheight: Int = 1,
                  weightx: Double = 0.0, weighty: Double = 0.0,
                  fill: GridBagPanel.Fill.Value = GridBagPanel.Fill.None, anchor: GridBagPanel.Anchor.Value = GridBagPanel.Anchor.NorthWest)
  : Constraints = {
    val c = new Constraints
    c.gridx = x
    c.gridy = y
    c.gridwidth = gridwidth
    c.gridheight = gridheight
    c.weightx = weightx
    c.weighty = weighty
    c.fill = fill
    c.anchor = anchor
    c
  }


}
