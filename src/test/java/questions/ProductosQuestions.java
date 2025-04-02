package questions;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.HomeUI;

public class ProductosQuestions {

    public static Question<String> nombreProducto(String producto) {
        return Text.of(HomeUI.productoEnCarrito(producto)).asString();
    }

    public static Question<String> precioProducto(String precio) {
        return Text.of(HomeUI.precioDelProducto(precio)).asString();
    }

}
