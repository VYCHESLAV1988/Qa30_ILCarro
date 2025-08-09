package tests;

import models.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
    public void loginSuccess1() {
        User user = new User().setEmail("svngdv@gmail.com").setPassword("A123456789a@");
        app.getHelperUser().openLoginForm(); //formula  ==   app. --> getHelperUser(). --> openLoginRegistrationForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Asert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    //    svngdv@gmail.com   A123456789a@      -login and password
    public void loginSuccess() {
        app.getHelperUser().openLoginForm(); //formula  ==   app. --> getHelperUser(). --> openLoginRegistrationForm();
        app.getHelperUser().fillLoginForm("svngdv@gmail.com", "A123456789a@");
        app.getHelperUser().submit();
        //Asert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm(); //formula  ==   app. --> getHelperUser(). --> openLoginRegistrationForm();
        app.getHelperUser().fillLoginForm("svngdv@gmail.com", "A123456789a@");
        app.getHelperUser().submit();
        //Asert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }

}
