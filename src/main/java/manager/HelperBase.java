package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {

    WebDriver wd;

    //Create Constructor for wd == click to right button mice and chose Generate to ==> Constructor only wd!
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    //Created method for HelperUser short commands type == have to take (By locator, String text) == By create class!
    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        //Created to check for text not null == to type
        if (text != null) {
            element.sendKeys(text);
        }
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
            //Aded method Surround with try/catch ==> Chose to .sleep --> More actions --> Surround with try/catch --> Ok
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void click(By locator) {
        WebElement element = wd.findElement(locator);
        element.click();
    }

    public boolean isElementPresent(By locator) {
        List<WebElement> list = wd.findElements(locator);
        return list.size() > 0;
    }


}
