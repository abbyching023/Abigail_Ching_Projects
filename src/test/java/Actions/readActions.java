package Actions;

import BaseUtil.baseUtil;
import ObjectPage.readPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;


public class readActions extends baseUtil {

    readPageObject readPageObject = new readPageObject(driver);

    public boolean verifyReadContactInfoPageVisible(){
        boolean flag = false;
        try {
            System.out.println("Verify if read page is visible");
            if (waitForElementVisible(readPageObject.readPageHeader)) {
                System.out.println("Successfully navigated to Read page");
                takeScreenShot("Read page screen visible");
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Failed to navigate to Read page");
        }
        return flag;
    }

    public boolean verifyExistingContactInformation(String[] fieldName) {
        ArrayList<Boolean> flags = new ArrayList<>();
        boolean flag = false;
        try {
            System.out.println("Verify table names");

            //verify actual column names with expected field name
            for (int i=0; i < fieldName.length; i++) {
                String actualLabel = readPageObject.tableFieldName.get(i).getText();
                if (fieldName[i].equalsIgnoreCase(actualLabel)) {
                    System.out.println("Expected field name: "+fieldName[i]+"\n Actual field name: "+actualLabel);
                    flags.add(true);
                } else {
                    System.out.println("Unexpected field name \n"+"Expected: "+fieldName[i]+", Actual: "+actualLabel);
                    flags.add(false);
                }
            }
            //verify if table data on first row is visible
            if (!readPageObject.tableDataFirstRow.isEmpty()) {
                System.out.println("Table is not empty");
                staticWaitTime("Small");
                takeScreenShot("Contact Info Table");
                //print field and its values
                for (int j=0; j < fieldName.length; j++) {
                    String actualData = readPageObject.tableDataFirstRow.get(j).getText();
                    System.out.println(fieldName[j]+": "+actualData+"\n");
                }
                flags.add(true);
            }

            if (!(flags.isEmpty() || flags.contains(false))) {
                flag = true;
                System.out.println("Successfully verified actual field labels and first row data");
            }

        } catch (Exception e) {
            System.out.println("Failed to verify to contact information table");
        }
        return flag;
    }

    public ArrayList<String> createdUpdatedContactInfoReadView(String id) {
        ArrayList<String> newData = new ArrayList<>();
        try {
            System.out.println("Search for the added contact information");
            int rowCount = 1;
            String targetDataXpath = "";
            if(waitForElementVisible(readPageObject.readPageHeader)) {
                takeScreenShot("Verify updated table");
                //search
                for (WebElement rowId : readPageObject.idColumns) {
                    if (rowId.getText().equals(id)) {
                        System.out.println("Identified newly added contact info");
                        targetDataXpath = "(//tbody//tr)[" + rowCount + "]//td"; //set xpath for the target row
                        break;
                    }
                    rowCount++;
                }
                //store
                List<WebElement> dataRow = driver.findElements(By.xpath(targetDataXpath));
                for (WebElement value : dataRow){
                    newData.add(value.getText());
                }
                newData.remove(newData.size()-1);
                newData.remove(newData.size()-1);
            } else {
                System.out.println("Read page was not displayed");
            }
        } catch (Exception e) {
            System.out.println("Failed to verify and store newly added/updated contact info");
            throw e;
        }
        return newData;
    }
}
