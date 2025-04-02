package tasks.api;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.model.environment.SystemEnvironmentVariables;

import java.util.HashMap;
import java.util.Map;
public class ActualizarUsuarioTask implements Task{

    private final String id;
    private final String nombre;
    private final String trabajo;
    private final String baseUrl;

    public ActualizarUsuarioTask(String id, String nombre, String trabajo) {
        this.id = id;
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.baseUrl = SystemEnvironmentVariables.createEnvironmentVariables()
                .getProperty("environments.default.api.url");
    }

    public static ActualizarUsuarioTask conId(String id, String nombre, String trabajo) {
        return Tasks.instrumented(ActualizarUsuarioTask.class, id, nombre, trabajo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> body = new HashMap<>();
        body.put("name", nombre);
        body.put("job", trabajo);

        SerenityRest
                .given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(baseUrl + "/users/" + id);

        System.out.println("Codigo de respuesta: " + SerenityRest.lastResponse().getStatusCode());
        System.out.println("Cuerpo de la respuesta: " + SerenityRest.lastResponse().getBody().asString());
    }
}