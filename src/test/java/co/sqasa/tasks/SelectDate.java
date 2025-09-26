package co.sqasa.tasks;

import co.sqasa.pages.DatePickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;

public class SelectDate implements Task {

    private String day;
    private boolean nextMonth;

    public SelectDate(String day, boolean nextMonth) {
        this.day = day;
        this.nextMonth = nextMonth;
    }

    public static SelectDate fromCurrentMonth(String day) {
        return Tasks.instrumented(SelectDate.class, day, false);
    }

    public static SelectDate fromNextMonth(String day) {
        return Tasks.instrumented(SelectDate.class, day, true);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(DatePickerPage.FRAME_CALENDAR.resolveFor(actor)), Click.on(DatePickerPage.DATE_INPUT)
        );
        if (nextMonth) {
            actor.attemptsTo(Click.on(DatePickerPage.NEXT_MONTH_BUTTON));
        }
        actor.attemptsTo(
                Click.on(DatePickerPage.dayOfMonth(day)),Switch.toDefaultContext()
        );
    }
}
