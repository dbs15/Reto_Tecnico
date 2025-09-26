package co.sqasa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.environment.SystemEnvironmentVariables;

public class OpenThePage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(SystemEnvironmentVariables.createEnvironmentVariables().getProperty("url-automate")));
    }

    public static OpenThePage theCalendar(){
      return Tasks.instrumented(OpenThePage.class);
    }

}
