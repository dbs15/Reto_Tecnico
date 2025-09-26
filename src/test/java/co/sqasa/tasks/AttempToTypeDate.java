package co.sqasa.tasks;

import co.sqasa.pages.DatePickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;

public class AttempToTypeDate implements Task {

    private String date;

    public AttempToTypeDate(String date) {
        this.date = date;
    }

    public static AttempToTypeDate withTheValue(String date){
        return Tasks.instrumented(AttempToTypeDate.class, date);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(DatePickerPage.FRAME_CALENDAR.resolveFor(actor)),
                Enter.theValue(date).into(DatePickerPage.DATE_INPUT),
                Switch.toDefaultContext()
        );

    }
}
