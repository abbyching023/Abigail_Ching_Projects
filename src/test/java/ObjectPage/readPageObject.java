package ObjectPage;

import BaseUtil.baseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class readPageObject extends baseUtil {

    public readPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(.,'Read Contacts')]")
    public WebElement readPageHeader;

    @FindBy(xpath = "//thead//tr//td")
    public List<WebElement> tableFieldName;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> tableDataFirstRow;

    @FindBy(xpath = "//a[contains(@href,'create')]")
    public WebElement createButton;

    @FindBy(xpath = "(//tbody//tr)//td[1]")
    public List<WebElement> idColumns;

    @FindBy(xpath = "(//a[contains(@href,'update')])[1]")
    public WebElement updateButtonFirstRow;

    @FindBy(xpath = "//*[contains(@href,'delete')]")
    public WebElement deleteButtons;





}
