package questions;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class CrudApi {
    public static Question<String> es() {
        return actor -> String.valueOf(SerenityRest.lastResponse().statusCode());
    }
}
