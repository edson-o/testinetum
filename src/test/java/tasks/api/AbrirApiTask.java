package tasks.api;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.model.environment.SystemEnvironmentVariables;


public class AbrirApiTask implements Task{

    private final String baseUrl;
    public AbrirApiTask() {
        this.baseUrl = SystemEnvironmentVariables.createEnvironmentVariables()
                .getProperty("environments.default.api.url");
    }

    public static AbrirApiTask desdeConfiguracion() {
        return Tasks.instrumented(AbrirApiTask.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest
                .given()
                .when()
                .get(baseUrl + "/users?page=2")
                .then()
                .statusCode(200);

        System.out.println("baseUrl: " + baseUrl);
    }
}