package features.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.HomePage;

import java.util.List;

import static utils.DriversUtils.setCapabilitiesChrome;

public class BookingSteps extends BasePage {

    HomePage homePage = new HomePage();
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        homePage.navigateToHomePage();
    }

    @When("I browse through the page")
    public void i_browse_through_the_page() {
        homePage.goToRoomsCategory();
    }
    @Then("I have the option to book a room")
    public void i_have_the_option_to_book_a_room() {
       homePage.assertBookButtonDisplayed();
    }

    @When("I select the amount of nights and starting date")
    public void iSelectTheAmountOfNightsAndStartingDate(DataTable tableNights) {
        homePage.clickOpenBookButton();

        List<List<String>> rows = tableNights.asLists(String.class);
        List<String> values = rows.get(1);
        homePage.selectAvailableNights(values.get(0), Integer.parseInt(values.get(1)));


    }

    @When("I fill in my information")
    public void i_fill_in_my_information(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        List<String> headers = rows.get(0);
        List<String> values = rows.get(1);

        for(int columns=0;columns<headers.size();columns++) {
            homePage.fillInInfo(headers.get(columns), values.get(columns));
        }

    }

    @And("I book the room")
    public void iBookTheRoom() {
        homePage.clickBookButton();
    }

    @Then("I should be able to successfully book a room")
    public void iShouldBeAbleToSuccessfullyBookARoom() {
        homePage.assertBookingSuccessful();
    }



}
