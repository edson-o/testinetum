package tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.HomeUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProductoTask implements Task {

    private final String nombreProducto;

    public ProductoTask(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static ProductoTask porNombre(String nombreProducto) {
        return instrumented(ProductoTask.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeUI.productoConNombre(nombreProducto))
        );
    }

}
