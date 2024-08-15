package ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deletePageObject {

    public deletePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(.,'Delete Contact')]")
    public WebElement deletePageHeader;

    @FindBy(xpath = "//a[contains(@href,'yes')]")
    public WebElement deleteYesBtn;

    @FindBy(xpath = "//a[contains(@href,'no')]")
    public WebElement deleteNoBtn;

    public String confirmationMsg = "//*[contains(text(),'%s')]";


}
