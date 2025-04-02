package tasks.api;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.model.environment.SystemEnvironmentVariables;

import java.util.HashMap;
import java.util.Map;

public class CrearUsuarioTask implements Task {

    private final String nombre;
    private final String trabajo;

    private final String baseUrl;

    public CrearUsuarioTask(String nombre, String trabajo) {
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.baseUrl = SystemEnvironmentVariables.createEnvironmentVariables()
                .getProperty("environments.default.api.url");
    }

    public static CrearUsuarioTask conDatos(String nombre, String trabajo) {
        return Tasks.instrumented(CrearUsuarioTask.class, nombre, trabajo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> body = new HashMap<>();
        body.put("name", nombre);
        body.put("job", trabajo);

        SerenityRest.given()
                .contentType("application/json")
                .body(body)
                .post(baseUrl + "/users");

        System.out.println("Codigo de respuesta: " + SerenityRest.lastResponse().getStatusCode());
        System.out.println("Cuerpo de la respuesta: " + SerenityRest.lastResponse().getBody().asString());

    }
}