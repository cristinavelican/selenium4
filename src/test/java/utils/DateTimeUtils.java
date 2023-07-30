package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utils.DriversUtils.*;

public class DateTimeUtils {

    public static void selectDatesInCalendar(WebElement dateFrom, WebElement dateTo){
        Actions action = new Actions(getDriver());
        action.clickAndHold(dateFrom).moveByOffset(-50,0).pause(1000)
                .moveToElement(dateTo)
                .release(dateTo)
                .build().perform();
    }

    public static String selectCurrentDay(){
        DateTimeFormatter currentDay = DateTimeFormatter.ofPattern("dd");
        LocalDateTime now = LocalDateTime.now();
        return currentDay.format(now);
    }
}
