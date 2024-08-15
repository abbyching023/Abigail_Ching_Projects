package Actions;

import BaseUtil.baseUtil;
import ObjectPage.homePageObject;

public class homeActions extends baseUtil {

    homePageObject homePageObject = new homePageObject(driver);

    public void launchUrl() {
        try {
            driver.get("http://localhost/phpcrud/index.php");
            staticWaitTime("Medium");
        } catch (Exception e){
            System.out.println("Failed to launch crud website");
        }

    }

    public boolean verifyHomePageVisible(){
        boolean flag = false;
        try {
            System.out.println("Waiting for home page to be visible");
            if (waitForElementVisible(homePageObject.pageTitle)) {
                System.out.println("Successfully navigated to home page");
                takeScreenShot("HomePage");
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Failed to navigate to Home page");
        }
        return flag;
    }

    public boolean navigateToReadPage() {
        boolean flag = false;
        try {
            System.out.println("Click Contact link to navigate to read page");
            if (clickElement(homePageObject.contactLink)) {
                staticWaitTime("Small");
                takeScreenShot("Read Page");
                System.out.println("Successfully clicked contact link");
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Failed to click to contact link");
        }
        return flag;
    }
}
