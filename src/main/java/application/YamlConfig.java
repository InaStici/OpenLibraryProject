package application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Data
//@EnableConfigurationProperties
//@ConfigurationProperties
public class YamlConfig {

    @Value(value = "${urls.homePageUrl}")
    String url;
    @Value("${timeouts.timeout}")
    long timeout;
    @Value("${driver.driverPath}")
    String driverPath;

}
