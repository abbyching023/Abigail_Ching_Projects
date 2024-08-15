package StepDefinition;

import Actions.createActions;
import Actions.updateActions;
import BeanFile.testContext.*;
import BeanFile.updatePageBean;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class updateStepDefinition {

    testContext testContext;
    updatePageBean updatePageBean;
    private final Actions.updateActions updateActions = new updateActions();
    private final Actions.createActions createActions = new createActions();

    public updateStepDefinition(testContext context){
        testContext = context;
        updatePageBean = testContext.getUpdatePageBean();
    }

    /**
     * Step to modify the contact information in Update page
     **/
    @When("User updates an existing contact information using {string}, {string}, {string}, {string} and {string}")
    public void userUpdatesExistingContactInformation(String id, String name, String email, String phone, String title) {

        Assert.assertTrue(updateActions.verifyUpdateContactInfoPageVisible());
        updatePageBean.setUpdatedContactInfoList(createActions.inputContactInfoDetails(id,name,email,phone,title));
        Assert.assertTrue(createActions.submitContactInfoChanges());

    }

}
