package Actions;

import BaseUtil.baseUtil;
import ObjectPage.createPageObject;
import ObjectPage.homePageObject;
import ObjectPage.readPageObject;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class createActions extends baseUtil {

    createPageObject createPageObject = new createPageObject(driver);
    readPageObject readPageObject = new readPageObject(driver);
    homePageObject homePageObject = new homePageObject(driver);

    public boolean verifyCreateContactInfoPageVisible() {
        boolean flag = false;
        try {
            System.out.println("Verify if create page is visible");
            clickElement(readPageObject.createButton);
            staticWaitTime("Small");
            if (waitForElementVisible(createPageObject.createPageHeader)) {
                System.out.println("Successfully navigated to Create page");
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Failed to navigate to Create page");
        }
        return flag;
    }

    public ArrayList<String> inputContactInfoDetails(String id, String name, String email, String phone, String title){
        ArrayList<String> data = new ArrayList<>();
        try {

            System.out.println("Creating new contact information data");
            staticWaitTime("Small");
            enterText(createPageObject.inputId,id);
            enterText(createPageObject.inputName,name);
            enterText(createPageObject.inputEmail,email);
            enterText(createPageObject.inputPhone,phone);
            enterText(createPageObject.inputTitle,title);
            String date = baseUtil.currentDateTime("MM/dd/yyyy", "hh:mm a");
            enterDate(createPageObject.inputDate,date);
            staticWaitTime("Small");
            takeScreenShot("Entered contact information details");

            //store into bean class before submit
            for (WebElement value : createPageObject.createInputFields) {
                data.add(value.getAttribute("value"));
            }

            data.remove(data.size()-1);
            data.remove(data.size()-1);

        } catch (Exception e) {
            System.out.println("Error occurred while entering contact information details");
            throw e;
        }
        return data;
    }

    public boolean submitContactInfoChanges() {
        boolean flag = false;
        try {

            System.out.println("Submitting contact information changes");
            clickElement(createPageObject.submitCreateBtn);

            if (waitForElementVisible(String.format(createPageObject.successfulMsgLabel,"Created Successfully!","Updated Successfully!"))) {
                System.out.println("Successfully created new contact information");
                takeScreenShot("Changes submitted");
                staticWaitTime("Small");
                clickElement(homePageObject.contactLink);
                flag = true;
            }

        } catch (Exception e) {
            System.out.println("Failed to submit new contact information");
            throw e;
        }
        return flag;
    }

}
