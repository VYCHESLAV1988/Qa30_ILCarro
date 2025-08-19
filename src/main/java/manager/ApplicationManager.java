package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser; //created link helperUser
    HelperCar helperCar;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init() {
        wd = new ChromeDriver();
        logger.info("== All test runs in Chrome Browser");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait( Duration.ofSeconds(7));
        wd.navigate().to("https://ilcarro.web.app");  //opened url and save to history taps
        logger.info("The link URL ==>" + wd.getCurrentUrl());  //logger opened url
        helperUser = new HelperUser(wd);
        helperCar = new HelperCar(wd);

    }

    public void stop() {
        //wd.quit(); // closed full tabs
    }
   //Create to Getter ==> click right button mice and chose Generate --> Getters --> HelperUser!

    public HelperUser getHelperUser() {
        return helperUser;
    }
    //added method for HelperCar
    public HelperCar getHelperCar() {
        return helperCar;
    }
}
