package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static utils.CommonUtils.*;
import static utils.DateTimeUtils.*;

import static utils.DriversUtils.*;
import static utils.WaitUtils.*;


public class HomePage {

    @FindBy(tagName = "h2")
    private WebElement roomCategoryIdentifier;

    @FindBy(xpath = "//button[contains(@class,'openBooking')]")
    private WebElement openBookButton;

    @FindBy(xpath = "(//button[contains(@class,'book-room')])[2]")
    private WebElement bookButton;

    @FindBy(xpath = "//div[contains(@class,\"confirmation-modal\")]//div//h3")
    private WebElement confirmationBooking;

    @FindBy(id = "submitContact")
    private WebElement submitButton;

    @FindBy(xpath = "(//h2)[2]")
    private WebElement thankYouMessage;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void goToRoomsCategory() {
        try {
            scrollToElement(roomCategoryIdentifier);
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("Error in the rooms category method");
        }
    }

    public void assertBookButtonDisplayed() {
        Assert.assertEquals(true, bookButton.isDisplayed());
    }

    public void navigateToHomePage() {
        getDriver().get("https://automationintesting.online/#/");
    }

    public void clickOpenBookButton() {
        openBookButton.click();

    }

    public void selectAvailableNights(String startingDate, int amountNights) {
        int endDate = 1;
        if (startingDate.equals("currentDay")) {
            startingDate = selectCurrentDay();
            endDate = Integer.parseInt(startingDate) + amountNights;
        }

        WebElement firstNightToBook = getDriver().findElement(By.xpath("//button[@class='rbc-button-link'][text()='" + startingDate + "']"));
        WebElement lastNightToBook;
        if (endDate < 10) {
            lastNightToBook = getDriver().findElement(By.xpath("//button[@class='rbc-button-link'][text()='" + 0 + String.valueOf(endDate) + "']"));
        } else {
            lastNightToBook = getDriver().findElement(By.xpath("//button[@class='rbc-button-link'][text()='" + String.valueOf(endDate) + "']"));
        }

        //Selenium 4 changes in Actions API
        selectDatesInCalendar(firstNightToBook, lastNightToBook);
    }

    public void fillInInfo(String locator, String value) {
        //replace the word REPLACE with the correct locator
        WebElement personalInfo = getDriver().findElement(By.xpath(String.format("//input[@aria-label='%s']", locator)));
        personalInfo.sendKeys(value);
    }

    public void clickBookButton() {
        bookButton.click();
    }

    public void assertBookingSuccessful() {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(confirmationBooking));
        waitUntilElementExists(confirmationBooking);
        System.out.println(confirmationBooking.getText());
        Assert.assertEquals("Booking Successful!", confirmationBooking.getText());
    }

    public void fillSubjectAndMessage(List<String> messageValues) {
        //FILLin the form using Relative locators related to the SUBMIT Button
        List<WebElement> formInformationFields = getDriver().findElements(with(
                By.className("form-control"))
                .above(By.id("submitContact")));
        System.out.println(formInformationFields.stream().count());

        for (String messageValue : messageValues)
            for (WebElement formInformation : formInformationFields) {
                System.out.println("value is:" + formInformation.getAttribute("value") + "here here2");
                if (formInformation.getAttribute("value") == null || formInformation.getAttribute("value").length() == 0) {
                    System.out.println("here here");
                    formInformation.sendKeys(messageValue);
                }
            }

        submitButton.click();
    }

    public void assertThankYouMessageDisplayed(String message) {
        waitUntilElementExists(thankYouMessage);
        System.out.println(thankYouMessage.getText());
       Assert.assertTrue(thankYouMessage.getText().contains(message));
    }
}

