package application.pom;

import application.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends CommonActions {

    @Autowired
    private WebDriver driver;

    @FindBy(xpath = "//div[@id = 'searchResults']/ul[@class = 'list-books']//li//div[@class = 'resultTitle']//a[@class = 'results']")
    public WebElement searchResultList;

    @FindBy(xpath = "//div[@id = 'searchResults']/ul[@class = 'list-books']//li//div[@class = 'resultTitle']//a[@class = 'results']")
    public List<WebElement> searchResultTitlesList;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getSearchResultList(){
        List<WebElement> resultList = new ArrayList<>();
        resultList = searchResultTitlesList;
        return resultList;
    }
}
