package manager;

import org.openqa.selenium.WebDriver;

public class HelperBase {

    WebDriver wd;
    //Create Constructor for wd == click to right button mice and chose Generate to ==> Constructor only wd!
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
}
