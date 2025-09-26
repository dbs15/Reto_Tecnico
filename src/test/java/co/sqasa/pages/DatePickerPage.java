package co.sqasa.pages;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatePickerPage {

    public static final Target DATE_INPUT = Target.the("campo de fecha").located(By.id("datepicker"));
    public static final Target FRAME_CALENDAR = Target.the("frame del calendario").located(By.className("demo-frame"));
    public static final Target NEXT_MONTH_BUTTON = Target.the("botón del mes siguiente").located(By.xpath("//a[contains(span/text(), 'Next')]"));
    public static Target dayOfMonth(String day) {
        return Target.the("día " + day + " del mes").located(By.xpath("//a[@data-date='" + day + "']"));
    }
}
