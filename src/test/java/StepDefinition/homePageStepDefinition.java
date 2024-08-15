package StepDefinition;

import Actions.homeActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class homePageStepDefinition {

    private final homeActions homeActions = new homeActions();

    @Given("User navigates to website homepage")
    public void navigateToWebsiteHomepage() {
        homeActions.launchUrl();
        Assert.assertTrue(homeActions.verifyHomePageVisible());
 }

    @When("User navigated to contact information read window page")
    public void userNavigatedToContactInformationReadWindowPage() {
        Assert.assertTrue(homeActions.navigateToReadPage());
    }

}
