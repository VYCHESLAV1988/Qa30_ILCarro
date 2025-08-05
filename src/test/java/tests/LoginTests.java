package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//public class LoginTests added extends TestBase!
public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //if button ' Logout ' present == click to ' Logout ' for check all tests
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    //    svngdv@gmail.com   A123456789a@      -login and password
    public void loginSuccess() {
        app.getHelperUser().openLoginRegistrationForm(); //formula  ==   app. --> getHelperUser(). --> openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("svngdv@gmail.com", "A123456789a@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().checkLoged();
        Assert.assertTrue(app.getHelperUser().isLogged());
        app.getHelperUser().logout();

    }

    @Test
    public void loginSuccess2() {
        app.getHelperUser().openLoginRegistrationForm(); //formula  ==   app. --> getHelperUser(). --> openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("svngdv@gmail.com", "A123456789a@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().checkLoged();
        Assert.assertTrue(app.getHelperUser().isLogged());
        app.getHelperUser().logout();
    }


}
