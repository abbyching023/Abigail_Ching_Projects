package StepDefinition;

import Actions.createActions;
import io.cucumber.java.en.When;
import org.junit.Assert;
import BeanFile.testContext.*;
import BeanFile.createPageBean;

public class createStepDefinition {

    testContext testContext;
    createPageBean createPageBean;
    private final Actions.createActions createActions = new createActions();

    public createStepDefinition(testContext context){
        testContext = context;
        createPageBean = testContext.getCreatePageBean();
    }


    /**
     * Step to navigate to create page, create new contact information & store the created data
     **/
    @When("User creates new contact information using {string}, {string}, {string}, {string} and {string}")
    public void createNewContactInformation(String id, String name, String email, String phone, String title) {
        Assert.assertTrue(createActions.verifyCreateContactInfoPageVisible());
        createPageBean.setCreatedContactInfoList(createActions.inputContactInfoDetails(id,name,email,phone,title));
        Assert.assertTrue(createActions.submitContactInfoChanges());
    }
}
