package Actions;

import BaseUtil.baseUtil;
import ObjectPage.homePageObject;
import ObjectPage.readPageObject;
import ObjectPage.updatePageObject;


public class updateActions extends baseUtil {

    updatePageObject updatePageObject = new updatePageObject(driver);
    readPageObject readPageObject = new readPageObject(driver);
    homePageObject homePageObject = new homePageObject(driver);

    public boolean verifyUpdateContactInfoPageVisible() {
        boolean flag = false;
        try {
            System.out.println("Verify if create page is visible");
            clickElement(readPageObject.updateButtonFirstRow);
            staticWaitTime("Small");
            if (waitForElementVisible(updatePageObject.updatePageHeader)) {
                System.out.println("Successfully navigated to Update page");
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Failed to navigate to Update page");
        }
        return flag;
    }

}
