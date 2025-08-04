package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    WebDriver wd;

 public void init(){
     wd = new ChromeDriver();
     wd.navigate().to("https://ilcarro.web.app");  //opened url and save to history taps
 }

 public void stop(){
    wd.quit(); // closed full tabs
 }
}
