package StepDefinition;

import Actions.readActions;
import BeanFile.testContext.*;
import BeanFile.createPageBean;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Arrays;

public class readStepDefinition {

    testContext testContext;
    createPageBean createPageBean;
    BeanFile.updatePageBean updatePageBean;
    private final Actions.readActions readActions = new readActions();

    public readStepDefinition(testContext context){
        testContext = context;
        createPageBean = testContext.getCreatePageBean();
        updatePageBean = testContext.getUpdatePageBean();
    }

    /**
     * Step to verify that user is able to see the read contact information page
     **/
    @Then("User should be able to see contact information read page")
    public void verifyReadContactInfoPageVisible() {
        Assert.assertTrue(readActions.verifyReadContactInfoPageVisible());
    }

    /**
     * Step to verify that user can read data from contact information table
     **/
    @And("User verify existing contact information")
    public void verifyExistingContactInformation() {
        String[] fieldName = {"id","Name","Email","Phone","Title","Created","Update/Delete"};
        Assert.assertTrue(readActions.verifyExistingContactInformation(fieldName));
    }

    /**
     * Step to verify that recently added contact info data matches the data displayed in table
     **/
    @Then("User should be able to view added contact information")
    public void userShouldBeAbleToViewAddedContactInformation() {
        var expectedContactInfo = createPageBean.getCreatedContactInfoList();
        var actualContactInfo = readActions.createdUpdatedContactInfoReadView(createPageBean.getCreatedContactInfoList().get(0));
        Assert.assertEquals(Arrays.asList(expectedContactInfo),Arrays.asList(actualContactInfo));
        System.out.println("Created contact information matches the data shown in table");
    }

    /**
     * Step to verify that recently modified contact info data matches the data displayed in table
     **/
    @Then("User should be able to view the modified contact information")
    public void userShouldBeAbleToViewTheModifiedContactInformation() {

        var expectedContactInfo = updatePageBean.getUpdatedContactInfoList();
        var actualContactInfo = readActions.createdUpdatedContactInfoReadView(updatePageBean.getUpdatedContactInfoList().get(0));
        Assert.assertEquals(Arrays.asList(expectedContactInfo),Arrays.asList(actualContactInfo));
        System.out.println("Updated contact information matches the data shown in table");
    }
}
