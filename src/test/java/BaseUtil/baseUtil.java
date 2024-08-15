package BaseUtil;


import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import Utility.Constants;

public class baseUtil {

    public static WebDriver driver;

    private static final Duration pageElementLoadWait = Duration.ofSeconds(10);

    public static Scenario scenario;

    public static int screenshotNumber = 1;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) { baseUtil.driver = driver; }

    /**
     * To get the file name of feature file
     *
     * @param scenario
     * @return String - Name of the scenario
     */

    public static String getFeaturefileName(Scenario scenario) {
        return scenario.getName();
    }

    public static String getFormattedFeatureFileName() {
        String featureName = "";
        try {
            featureName = getFeaturefileName(scenario).split(" : ")[0].replaceAll("/", "-");
        } catch (Exception e) {
            System.out.println("Exception Occurred in getFormattedFeatureFileName: " + e.getMessage());
        }
        return featureName;
    }
    /**
     * To wait for fixed amount of time
     * @param waitType Types: small, medium, large and long
     */
    public static void staticWaitTime(String waitType) {
        try {
            if (waitType.equals("Small")) {
                Thread.sleep(2000);
                System.out.println("Waited for 2000 milli seconds");
            } else if (waitType.equals("Medium")) {
                Thread.sleep(5000);
                System.out.println("Waited for 5000 milli seconds");
            } else if (waitType.equals("High")) {
                Thread.sleep(10000);
                System.out.println("Waited for 10000 milli seconds");
            } else if (waitType.equals("Long")) {
                Thread.sleep(15000);
                System.out.println("Waited for 15000 milli seconds");
            } else {
                Thread.sleep(4000);
                System.out.println("Waited for 4000 milli seconds");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in static wait:-" + e.getMessage());
        }
    }

    /**
     * Convert Xpath into web element
     *
     * @param xpath string xpath
     * @return WebElement
     */
    public static WebElement convertToWebElement(String xpath) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element = driver.findElement(By.xpath(String.format(xpath)));
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Exception occurred in convertToWebElement:-" + e.getMessage());
        }
        return element;
    }

    /**
     * Explicit Wait for Element to be visible
     *
     * @param element WebElement
     * returns boolean
     */
    public static boolean waitForElementVisible(WebElement element) {
        boolean flag = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, pageElementLoadWait);
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Element is visible");
            flag = true;
        } catch (Exception e) {
            System.out.println("Exception occurred in waitForElementVisible:-" + e.getMessage());
        }
        return flag;
    }

    /**
     * Fluent wait for checking if the element is not present
     **/
    public boolean waitForInvisibilityOfElementIntermittent(WebElement element) {
        boolean flag = false;
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
            flag = wait.until(ExpectedConditions.invisibilityOf(element));
            System.out.println("Element is invisible");
        } catch (Exception e) {
            System.out.println("Element not invisible: " + e.getMessage());
        }
        return flag;
    }

    /**
     * Fluent wait for checking the visibility of the element
     *
     */
    public boolean waitForVisibilityOfElementIntermittent(WebElement element) {
        boolean flag = false;
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            flag = true;
            System.out.println("Element is visible");
        } catch (Exception e) {
            System.out.println("Element not visible: " + e.getMessage());
        }
        return flag;
    }

    /**
     * Wait for Element to be visible
     *
     * @param element - Xpath of WebElement
     * @return boolean
     */
    public static boolean waitForElementVisible(String element) {
        boolean flag = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, pageElementLoadWait);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
            System.out.println("Element is visible");
            flag = true;
        } catch (Exception e) {
            System.out.println("Exception occurred in waitForElementVisible:-" + e.getMessage());
        }
        return flag;
    }

    /**
     * Wait for Element to be clickable
     *
     * @param element WebElement
     * @return boolean
     */
    public static boolean waitForElementClickable(WebElement element) {
        boolean flag = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, pageElementLoadWait);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("Element is clickable");
            flag = true;
        } catch (Exception e) {
            System.out.println("Exception occurred in waitForElementClickable:-" + e.getMessage());
        }
        return flag;
    }

    /**
     * Fluent Wait for ignore stale exception and find target element
     *
     * @param element WebElement
     * @return boolean
     */
    public static boolean handleStaleElement(WebElement element) {
        boolean flag = false;
        try {
            String elem = String.valueOf(element);
            Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(120)).pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
            wait.until(driver -> driver.findElement(By.xpath(elem)));
            flag = true;
        } catch (Exception e) {
            System.out.println("Exception occurred in handling stale element:-" + e.getMessage());
        }
        return flag;
    }

    /**
     * Selenium method to click
     *
     * @param element WebElement
     * @return boolean
     */
    public static boolean clickElement(WebElement element) {
        boolean flag = false;
        try {
            if (waitForElementClickable(element)) {
                element.click();
                System.out.println("Element Clicked");
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in clickElement:-" + e.getMessage());
        }
        return flag;
    }

    /**
     * Enter text in text box method.
     *
     * @param element WebElement
     * @param input value
     */
    public static void enterText(WebElement element, String input) {
        try {
            if (clickElement(element)) {
                Thread.sleep(500);
                element.clear();
                Thread.sleep(500);
                element.sendKeys(input);
                System.out.println("Entered the text - " + input);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in enterText:-" + e.getMessage());
        }
    }

    /**
     * Enter text in text box method.
     *
     * @param xpath string xpath
     * @param input date
     */
    public void enterDate(String xpath, String input) {
        try {
            WebElement element = convertToWebElement(xpath);
            if (element != null) {
                Thread.sleep(500);
                clickElement(element);
                Thread.sleep(500);
                element.sendKeys(input);
                System.out.println("Date entered - " + input);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred in enterDate:-" + e.getMessage());
        }
    }

    /**
     * Method to get current date and time
     * Return: Date and Time String
     * Input Parameters: date and time format
     **/
    public static String currentDateTime(String dateFormat, String timeFormat) {
        String dateTime = null;
        try {
            //get current date
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            String formattedDate = currentDate.format(formatter);
            System.out.println("Current date: " + formattedDate);
            //get current time
            LocalTime currentTime = LocalTime.now();
            formatter = DateTimeFormatter.ofPattern(timeFormat);
            String formattedTime = currentTime.format(formatter);
            System.out.println("Current time: " + formattedTime);
            //get both date and time
            dateTime = formattedDate+ " " + formattedTime;
            System.out.println("Date and Time "+dateTime);

        } catch (Exception e) {
            System.out.println("Failed to get current date and time" + e);
        }
        return dateTime;
    }

    /**
     * Taking screenshots
     *
     * @param fileName File name
     */
    public static void takeScreenShot(String fileName) {
        String imgName = fileName.replaceAll("/", "-") + ".png";
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(Constants.sScreenshotFilepath +
                    getFeaturefileName(scenario).split(" : ")[0].replaceAll("/", "-") + "/" + screenshotNumber + " - " + imgName));
            System.out.println("Screenshot captured - " + screenshotNumber + " - " + fileName);
            screenshotNumber++;

        } catch (Exception e) {
            System.out.println("Exception occurred in takeScreenShot: " + e.getMessage());
        }
    }

}
