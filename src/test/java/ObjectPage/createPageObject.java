package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class createPageObject {

    public createPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(.,'Create Contact')]")
    public WebElement createPageHeader;

    @FindBy(xpath = "//input[@name=\"id\"]")
    public WebElement inputId;

    @FindBy(xpath = "//input[@name=\"name\"]")
    public WebElement inputName;

    @FindBy(xpath = "//input[@name=\"email\"]")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@name=\"phone\"]")
    public WebElement inputPhone;

    @FindBy(xpath = "//input[@name=\"title\"]")
    public WebElement inputTitle;

    public String inputDate = "//input[@name=\"created\"]";

    @FindBy(xpath = "//input[@type=\"submit\"]")
    public WebElement submitCreateBtn;

    public String successfulMsgLabel = "//*[contains(.,'%s') or contains(.,'%s')]";

    @FindBy(xpath = "//input")
    public List<WebElement> createInputFields;


}
