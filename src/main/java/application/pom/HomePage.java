package application.pom;

import application.CommonActions;
import application.YamlConfig;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends CommonActions {

    @Autowired
    private WebDriver driver;
    @Autowired
    private YamlConfig yamlConfig;
    @FindBy(xpath = "//div[@class = 'logo-txt']")
    public WebElement logo;

    @Name("Sign Up")
    @FindBy(xpath = "//a[@class  = 'btn primary' and text() = 'Sign Up']")
    public WebElement signUpBtn;

    @FindBy(xpath = "//a[@class  = 'btn' and text() = 'Log In']")
    public WebElement logInBtn;

    @FindBy(xpath = "//div[@class = 'search-component']//input[@name = 'q']")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@class = 'search-component']//input[@type = 'submit']")
    public WebElement searchSubmit;

    @FindBy(xpath = "//header[@id = 'header-bar']//ul[@class = 'navigation-component']/li/div[@class = 'browse-component header-dropdown']")
    public WebElement browseDropdown;

    @FindBy(xpath = "//header[@id = 'header-bar']//ul[@class = 'navigation-component']//div[contains(@class, 'browse-dropdown-component')]//li/a[contains(text(), 'Trending')]")
    public WebElement browseDropdownTrendingItem;

    @FindBy(xpath = "")
    public WebElement loginButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get(yamlConfig.getUrl());
        driver.manage().window().maximize();
        doImplicitlyWait();
    }

    public void displayLogo() {
        logo.isDisplayed();
    }

    public void doSearch(String searchKeyword){
        searchInput.sendKeys(searchKeyword);
        searchSubmit.click();
    }
}
