package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.HomeUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MultipleProductoTask implements Task {

    private final String nombreProducto;

    public MultipleProductoTask(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static MultipleProductoTask conNombre(String nombreProducto) {
        return instrumented(MultipleProductoTask.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Click.on(HomeUI.botonAgregarProducto(nombreProducto))
        );
    }
}