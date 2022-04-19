import java.awt.Dimension
import scala.swing.MainFrame

class AppWindowUI extends MainFrame {
  title = "Pizza Calculator"
  preferredSize = new Dimension(600, 400)
  minimumSize = new Dimension(400, 400)
  contents = new LayoutPanel
}


object PizzaCalculator extends App {

  val appWindow = new AppWindowUI
  appWindow.visible = true

}
