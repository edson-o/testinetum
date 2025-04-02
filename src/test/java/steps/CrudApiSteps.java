package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.CrudApi;
import tasks.api.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class CrudApiSteps {

    @Given("el actor usa la API de Reqres")
    public void elActorUsaLaApi() {
        theActorCalled("Edson").attemptsTo(
                AbrirApiTask.desdeConfiguracion()
        );
    }

    @When("crea un nuevo usuario con nombre {string} y trabajo {string}")
    public void crearUsuario(String nombre, String trabajo) {
        theActorInTheSpotlight().attemptsTo(
                CrearUsuarioTask.conDatos(nombre, trabajo)
        );
    }

    @When("obtiene el usuario con id {string}")
    public void obtenerUsuario(String id) {
        theActorInTheSpotlight().attemptsTo(
                ObtenerUsuarioTask.conId(id)
        );
    }

    @When("actualiza el usuario con id {string} a nombre {string} y trabajo {string}")
    public void actualizarUsuario(String id, String nombre, String trabajo) {
        theActorInTheSpotlight().attemptsTo(
                ActualizarUsuarioTask.conId(id, nombre, trabajo)
        );
    }

    @When("elimina el usuario con id {string}")
    public void eliminarUsuario(String id) {
        theActorInTheSpotlight().attemptsTo(
                EliminarUsuarioTask.conId(id)
        );
    }

    @Then("validar codigo de respuesta {string}")
    public void validarCodigoRespuesta(String codigo) {
        theActorInTheSpotlight().should(
                seeThat(CrudApi.es(), is(codigo))
        );
    }
}