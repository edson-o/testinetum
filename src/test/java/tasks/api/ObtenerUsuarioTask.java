package tasks.api;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.model.environment.SystemEnvironmentVariables;
public class ObtenerUsuarioTask  implements Task {

    private final String id;
    private final String baseUrl;

    public ObtenerUsuarioTask(String id) {
        this.id = id;
        this.baseUrl = SystemEnvironmentVariables.createEnvironmentVariables()
                .getProperty("environments.default.api.url");
    }

    public static ObtenerUsuarioTask conId(String id) {
        return Tasks.instrumented(ObtenerUsuarioTask.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest
                .given()
                .when()
                .get(baseUrl + "/users?page=" + id);


        System.out.println("Codigo de respuesta: " + SerenityRest.lastResponse().getStatusCode());
        System.out.println("Cuerpo de la respuesta: " + SerenityRest.lastResponse().getBody().asString());
    }
}