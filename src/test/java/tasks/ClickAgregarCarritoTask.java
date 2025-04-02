package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.HomeUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickAgregarCarritoTask implements Task {

    public static ClickAgregarCarritoTask ahora() {
        return instrumented(ClickAgregarCarritoTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeUI.BOTON_ADD_TO_CART)
        );
    }
}
