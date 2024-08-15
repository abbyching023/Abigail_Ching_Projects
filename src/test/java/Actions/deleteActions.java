package Actions;

import BaseUtil.baseUtil;
import ObjectPage.deletePageObject;
import ObjectPage.homePageObject;
import ObjectPage.readPageObject;

import java.util.ArrayList;

public class deleteActions extends baseUtil {

    readPageObject readPageObject = new readPageObject(driver);
    deletePageObject deletePageObject = new deletePageObject(driver);
    homePageObject homePageObject = new homePageObject(driver);

    public boolean deleteAndVerifyRemovedContactInformation() {
        boolean flag = false;
        ArrayList<Boolean> flags = new ArrayList<>();
        try {
            System.out.println("Delete existing contact information");
            int flagCounter = 0;
            //delete every visible item
            do {
                clickElement(readPageObject.deleteButtons);
                staticWaitTime("Small");
                takeScreenShot("Delete item confirmation");
                if (waitForElementVisible(deletePageObject.deletePageHeader)) {
                    String[] splitHeaderTxt = deletePageObject.deletePageHeader.getText().split("\\s+");
                    String itemId = splitHeaderTxt[splitHeaderTxt.length - 1];
                    clickElement(deletePageObject.deleteYesBtn);
                    staticWaitTime("Small");
                    flags.add(waitForElementVisible(String.format(deletePageObject.confirmationMsg, "You have deleted the contact!")));
                    takeScreenShot("Delete confirmation message");
                    System.out.println("Deleted item ID: " + itemId);
                    clickElement(homePageObject.contactLink);
                    staticWaitTime("Small");
                    driver.navigate().refresh();
                    flagCounter++;
                }  else {
                    System.out.println("Error in navigating to delete confirmation page");
                }
            } while (waitForVisibilityOfElementIntermittent(readPageObject.deleteButtons));

            //verify if all items were removed
            if (waitForInvisibilityOfElementIntermittent(readPageObject.deleteButtons)) {
                takeScreenShot("Empty contact info table");
                flags.add(true);
            }
            flagCounter = flagCounter+1;
            if (flags.size() == flagCounter && !flags.contains(false)) {
                System.out.println("Successfully deleted all data");
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Error occurred while deleting contact information");
        }
        return flag;
    }
}
