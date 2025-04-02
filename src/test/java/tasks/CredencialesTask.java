package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import ui.LoginPageUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class CredencialesTask implements Task {

    private final String usuario;
    private final String contrasena;

    public CredencialesTask(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static CredencialesTask con(String usuario, String contrasena) {
        return instrumented(CredencialesTask.class, usuario, contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPageUI.USER_INPUT),
                Enter.theValue(contrasena).into(LoginPageUI.PASSWORD_INPUT)
        );
    }
}
