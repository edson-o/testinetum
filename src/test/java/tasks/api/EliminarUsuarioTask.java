package tasks.api;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.model.environment.SystemEnvironmentVariables;
public class EliminarUsuarioTask  implements Task {

    private final String id;
    private final String baseUrl;

    public EliminarUsuarioTask(String id) {
        this.id = id;
        this.baseUrl = SystemEnvironmentVariables.createEnvironmentVariables()
                .getProperty("environments.default.api.url");
    }

    public static EliminarUsuarioTask conId(String id) {
        return Tasks.instrumented(EliminarUsuarioTask.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest
                .given()
                .when()
                .delete(baseUrl + "/users/" + id);

        System.out.println("Codigo de respuesta: " + SerenityRest.lastResponse().getStatusCode());
    }
}