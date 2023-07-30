package features.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import java.util.List;

public class ContactUsSteps {

    HomePage homePage = new HomePage();
    @When("I submit my feedback")
    public void i_submit_my_feedback(DataTable  feedbackTable) {
        //submit using Relative locators - Selenium4
        List<List<String>> feedbackTableAsList = feedbackTable.asLists(String.class);
        List<String> feedbackValues = feedbackTableAsList.get(1);
        homePage.fillSubjectAndMessage(feedbackValues);
    }

    @Then("I can see the personalized successful message {string}")
    public void i_can_see_the_personalized_successful_message(String message) {
       homePage.assertThankYouMessageDisplayed(message);
    }
}
