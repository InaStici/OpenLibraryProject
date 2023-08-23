package stepdefinitions;

import application.CommonActions;
import application.YamlConfig;
import application.pom.AccountCreatePage;
import application.pom.HomePage;
import application.pom.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;
@Slf4j
public class StepDefinitions extends CommonActions {

    @Autowired
    private WebDriver driver;
    @Autowired
    private YamlConfig yamlConfig;
    @Autowired
    private HomePage homePage;
    @Autowired
    private AccountCreatePage accountCreatePage;
    @Autowired
    private SearchPage searchPage;

    @And("open home page")
    public void openHomePage() {



//        HomePage homePage = new HomePage(driver);
//        homePage.openHomePage();
        openBrowser();
        homePage.displayLogo();
        log.info("Opened home page");
    }

    @When("search by {string} keyword")
    public void searchByKeyword(String keyword) {
//        HomePage homePage = new HomePage(driver);
        homePage.doSearch(keyword);
        doImplicitlyWait();
        searchPage.searchResultList.isDisplayed();
    }

    @Then("list all search results")
    public void listAllSearchResults() {
        SearchPage searchPage = new SearchPage(driver);
        List<String> list = new ArrayList<>();
        searchPage.getSearchResultList().forEach(c -> {
            list.add(c.getText());
        });

        list.forEach(record -> {
            System.out.println(format("Book title: %s", record));
        });

    }

    @And("browse Trending item")
    public void browseTrendingItem() {
//        HomePage homePage = new HomePage(driver);
        homePage.browseDropdown.click();
        homePage.browseDropdownTrendingItem.isDisplayed();
        homePage.browseDropdownTrendingItem.click();
       doImplicitlyWait();
    }

    @When("user clicks on {string} button")
    public void userClicksOnSignUpButton(String btnName) {
        log.info("Click on button");
        homePage.signUpBtn.click();
        doImplicitlyWait();
    }

    @Then("user is redirected to {string} page")
    public void userIsRedirectedToSignUpPage(String pageName) {
        AccountCreatePage acctCreatePage = new AccountCreatePage();
        assertTrue(getLocator(acctCreatePage.headerText, pageName).isDisplayed());
    }
}
