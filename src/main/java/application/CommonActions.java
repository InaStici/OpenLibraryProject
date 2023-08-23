package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class CommonActions extends WebDriverManager{

    @Autowired
    private WebDriver driver;
    @Autowired
    private YamlConfig yamlConfig;



    protected WebElement getLocator(WebElement xpath, String containingText){
        return driver.findElement(By.xpath(String.valueOf(xpath).formatted(containingText)));
    }

}
