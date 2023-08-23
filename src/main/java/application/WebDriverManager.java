package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@Component
public class WebDriverManager {

    WebDriver driver;

    @Autowired
    private YamlConfig yamlConfig;
    @Bean
    public WebDriver webDriver() {
        ChromeOptions options = new ChromeOptions()
                .addArguments("--no-sandbox")
                .setHeadless(true);

        System.setProperty("webdriver.chrome.driver", yamlConfig.getDriverPath());
        ChromeDriver driver = new ChromeDriver(options);
        driver.setLogLevel(Level.WARNING);

        return driver;
    }

    protected void doImplicitlyWait(){
        driver.manage().timeouts().implicitlyWait(yamlConfig.getTimeout(), TimeUnit.SECONDS);
    }

    public void openBrowser(){

        driver.get(yamlConfig.getUrl());
        driver.manage().window().maximize();
        doImplicitlyWait();
    }
}
