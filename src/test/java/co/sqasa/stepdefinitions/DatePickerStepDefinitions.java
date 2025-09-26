package co.sqasa.stepdefinitions;

import co.sqasa.questions.TheSelectedDate;
import co.sqasa.tasks.AttempToTypeDate;
import co.sqasa.tasks.OpenThePage;
import co.sqasa.tasks.SelectDate;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class DatePickerStepDefinitions extends BaseOpen{
    @Dado("que el usuario abre la pagina de JQuery Datepicker")
    public void queElUsuarioAbreLaPaginaDeJQueryDatepicker() {
        theActorInTheSpotlight().attemptsTo(OpenThePage.theCalendar());
    }

    @Cuando("el usuario selecciona el dia {string} del mes actual")
    public void elUsuarioSeleccionaElDiaDelMesActual(String day) {
         BrowseTheWeb.as(theActorInTheSpotlight()).waitFor(2).second();
        theActorInTheSpotlight().attemptsTo(SelectDate.fromCurrentMonth(day));
    }

    @Entonces("el deberia ver la fecha seleccionada en el campo de texto")
    public void elDeberiaVerLaFechaSeleccionadaEnElCampoDeTexto() {
         BrowseTheWeb.as(theActorInTheSpotlight()).waitFor(2).second();
        LocalDate today = LocalDate.now();
        String expectedDate = String.format("%02d/15/%d", today.getMonthValue(), today.getYear());
        theActorInTheSpotlight().should(seeThat("la fecha seleccionada", TheSelectedDate.is(), equalTo(expectedDate)));
    }

    @Cuando("el usuario navega al proximo mes y selecciona el dia {string}")
    public void elUsuarioNavegaAlProximoMesYSeleccionaElDia(String day) {
         BrowseTheWeb.as(theActorInTheSpotlight()).waitFor(2).second();
        theActorInTheSpotlight().attemptsTo(SelectDate.fromNextMonth(day));
    }

    @Entonces("el deberia ver la fecha del proximo mes seleccionada en el campo de texto")
    public void elDeberiaVerLaFechaDelProximoMesSeleccionadaEnElCampoDeTexto() {
         BrowseTheWeb.as(theActorInTheSpotlight()).waitFor(2).second();
        LocalDate nextMonthDate = LocalDate.now().plusMonths(1).withDayOfMonth(10);
        String expectedDate = nextMonthDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        theActorInTheSpotlight().should(
                seeThat("la fecha del próximo mes", TheSelectedDate.is(), equalTo(expectedDate))
        );
    }

    @Cuando("el intenta ingresar la fecha {string} manualmente")
    public void elIntentaIngresarLaFechaManualmente(String date) {
         BrowseTheWeb.as(theActorInTheSpotlight()).waitFor(2).second();
        theActorInTheSpotlight().attemptsTo(AttempToTypeDate.withTheValue(date));
    }


    @Entonces("el campo de fecha no deberia cambiar")
    public void elCampoDeFechaNoDeberiaCambiar() {
         BrowseTheWeb.as(theActorInTheSpotlight()).waitFor(2).second();
        theActorInTheSpotlight().should(
                seeThat("el valor del campo de fecha", TheSelectedDate.is(), not(equalTo("05/20/2024")))
        );
    }
}
