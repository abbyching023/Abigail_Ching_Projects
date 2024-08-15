package StepDefinition;

import BaseUtil.baseUtil;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.ByteArrayInputStream;
import java.io.File;
import Utility.Constants;




public class Hooks extends baseUtil  {

    @Before
    public void initializeBrowser(Scenario scenario) {
        baseUtil.scenario = scenario;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Opened Chrome");
        driver.manage().deleteAllCookies();
        staticWaitTime("Small");
    }
    @After
    public void tearDownTest(Scenario scenario) {
        driver.manage().deleteAllCookies();
        System.out.println("tearDownTest - Driver closed");
        if (scenario.isFailed()) {
            String imgName = "Failed Step.jpeg";
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(Constants.fScreenshotFilepath + imgName));
                System.out.println("tearDownTest - Screenshot captured");
                Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

            } catch (Exception e) {
                System.out.println("tearDownTest - Screenshot exception: "+e.getMessage());
            }
        }
        driver.quit();
    }
}
