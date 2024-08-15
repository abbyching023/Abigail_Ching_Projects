package StepDefinition;

import Actions.deleteActions;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class deleteStepDefinition {

    deleteActions deleteActions = new deleteActions();

    @Then("User deletes existing contact information")
    public void userNavigatedToContactInformationReadWindowPage() {
        Assert.assertTrue(deleteActions.deleteAndVerifyRemovedContactInformation());
    }

}
