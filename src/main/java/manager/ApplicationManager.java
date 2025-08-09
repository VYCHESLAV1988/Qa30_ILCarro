package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser; //created link helperUser

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        wd.navigate().to("https://ilcarro.web.app");  //opened url and save to history taps
        helperUser = new HelperUser(wd);

    }

    public void stop() {
        //wd.quit(); // closed full tabs
    }
   //Create to Getter ==> click right button mice and chose Generate --> Getters --> HelperUser!

    public HelperUser getHelperUser() {
        return helperUser;
    }
}
