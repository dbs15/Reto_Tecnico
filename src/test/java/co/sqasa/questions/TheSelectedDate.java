package co.sqasa.questions;

import co.sqasa.pages.DatePickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Value;

public class TheSelectedDate implements Question<String> {
    public static Question<String> is(){
        return new TheSelectedDate();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(Switch.toFrame(DatePickerPage.FRAME_CALENDAR.resolveFor(actor)));
        String dateValue = Value.of(DatePickerPage.DATE_INPUT).answeredBy(actor);
        actor.attemptsTo(Switch.toDefaultContext());
        return dateValue;
    }
}
