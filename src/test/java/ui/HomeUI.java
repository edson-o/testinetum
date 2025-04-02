package ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUI {

    public static Target productoConNombre(String nombreProducto) {
        return Target.the("producto con nombre " + nombreProducto)
                .located(By.xpath("//div[@class='inventory_item_name ' and text()='" + nombreProducto + "']"));
    }

    public static final Target BOTON_ADD_TO_CART = Target.the("botón Add to cart")
            .located(By.xpath("//button[text()='Add to cart']"));

    public static Target productoEnCarrito(String producto) {
        return Target.the("producto en el carrito")
                .located(By.xpath("//div[@class='inventory_item_name' and text()='" + producto + "']"));
    }

    public static Target precioDelProducto(String precio) {
        return Target.the("precio del producto en el carrito")
                .located(By.xpath("//div[@class='inventory_item_price' and contains(normalize-space(.), '"+precio+"')]"));
    }

    public static final Target CARRITO_ICONO = Target.the("ícono del carrito")
            .located(By.cssSelector("a.shopping_cart_link"));

    public static Target botonAgregarProducto(String nombreProducto) {
        return Target.the("botón Add to cart para " + nombreProducto)
                .located(By.xpath("//div[text()='" + nombreProducto + "']/ancestor::div[@class='inventory_item']//button"));
    }
}
