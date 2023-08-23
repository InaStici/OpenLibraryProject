package application.pom;

import application.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.util.Assert;

public class AccountCreatePage extends CommonActions {

    //Input data for sign up section
    @FindBy(xpath = "//div[@id= 'contentHead']/h1[text() = '%s']")
    public WebElement headerText;

    @FindBy(id = "emailAddr")
    public WebElement emailInput;

    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "password2")
    public WebElement confirmPasswordInput;

    @FindBy(id = "ia_newsletter")
    public WebElement receiveNewsCheckBox;

    @FindBy(xpath = "//span[@aria-checked = 'false' and @ id = 'recaptcha-anchor']")
    public WebElement recapchaUncheckedCheckBox;

    @FindBy(xpath = "//span[@aria-checked = 'true' and @ id = 'recaptcha-anchor']")
    public WebElement recapchaCheckedCheckBox;

    @FindBy(xpath = "//small[contains(text(), \"By signing up, you agree to the Internet Archive's\")]")
    public WebElement termsOfServiceText;

    @FindBy(xpath = "//small/a[(text() = 'Terms of Service')]")
    public WebElement termsOfServiceLink;

    @FindBy(xpath = "//div[@class = 'formElement bottom']/button[@id = 'signup']")
    public WebElement signUpBtn;

    @FindBy(xpath = "//div[@class = 'formElement bottom']/a[text() = 'Cancel']")
    public WebElement cancelBtn;

    //Sign up completed section
    @FindBy(xpath = "//div[@id= 'contentHead']/h1[text() = 'Hi, %s']")
    public WebElement headerWelcomeText;

    @FindBy(id = "contentBody")
    public WebElement contentBodyText;


    public void completeAllRequiredFieldsSignUp(String email, String userName,
                                                String password, boolean isChecked) {
        emailInput.sendKeys(email);
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        if (isChecked)
            receiveNewsCheckBox.click();
        recapchaUncheckedCheckBox.click();
        doImplicitlyWait();
//        assertTrue(recapchaCheckedCheckBox.isDisplayed());
        Assert.isTrue(recapchaCheckedCheckBox.isDisplayed(), "Recapcha is checked");
    }

    public void checkCreatedUserMessage(String email, String userName){
        Assert.isTrue(getLocator(headerWelcomeText, userName).isDisplayed(), "Header message is displayed");
    }

}
