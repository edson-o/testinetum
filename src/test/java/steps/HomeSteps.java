package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.ProductosQuestions;
import tasks.*;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class HomeSteps {

    @Before
    public void setThePage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el actor abre la pagina web")
    public void abrirLaWeb() {
        OnStage.theActorCalled("Edson").attemptsTo(
                HomeTask.login()
        );

    }

    @When("ingresar el usuario {string} y la clave {string}")
    public void ingresarCredenciales(String user, String pass) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CredencialesTask.con(user, pass)
        );
    }

    @And("clic in the boton Login")
    public void botonLogin() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                new ClickEnLoginTask()
        );
    }

    @And("selecciona el producto {string}")
    public void seleccionarProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProductoTask.porNombre(producto)
        );
    }

    @Then("clic en el boton Add to cart")
    public void botonAgregarCarrito() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                new ClickAgregarCarritoTask()
        );


    }

    @And("el carrito debe mostrar el producto {string} con precio {string}")
    public void carritoDeCompras(String producto, String precio) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                new clickIrCarritoTask()
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductosQuestions.nombreProducto(producto), is(producto)),
                seeThat(ProductosQuestions.precioProducto(precio), is(precio))
        );
    }

    @And("selecciona y agrega los productos")
    public void multipleProductos(DataTable dataTable) {
        List<Map<String, String>> listaProductos = dataTable.asMaps(String.class, String.class);

        OnStage.theActorInTheSpotlight().remember("productosSeleccionados", listaProductos);


        for (Map<String, String> producto : listaProductos) {
            String nombre = producto.get("producto");

            OnStage.theActorInTheSpotlight().attemptsTo(
                    MultipleProductoTask.conNombre(nombre)
            );
        }
    }

    @Then("el carrito debe mostrar los productos con sus precios")
    public void validarMulltipleProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                new clickIrCarritoTask()
        );
        List<Map<String, String>> productos = OnStage.theActorInTheSpotlight()
                .recall("productosSeleccionados");

        for (Map<String, String> producto : productos) {
            String nombre = producto.get("producto");
            String precio = producto.get("precio");

            OnStage.theActorInTheSpotlight().should(
                    seeThat(ProductosQuestions.nombreProducto(nombre), is(nombre)),
                    seeThat(ProductosQuestions.precioProducto(precio), is(precio))
            );
        }
    }


}
