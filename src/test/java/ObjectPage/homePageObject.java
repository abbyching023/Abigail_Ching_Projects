package ObjectPage;

import BaseUtil.baseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePageObject extends baseUtil {

    public homePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'CRUD')]")
    public WebElement pageTitle;

    @FindBy(linkText = "index.php")
    public WebElement homePageLink;

    @FindBy(xpath = "//*[@href=\"read.php\"]")
    public WebElement contactLink;

    public String homePageContent = "//*[contains(text(),'%s')]";


}
