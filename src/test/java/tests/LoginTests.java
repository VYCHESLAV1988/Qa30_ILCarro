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
    //formula  ==   app. --> getHelperUser(). --> openLoginRegistrationForm();
    public void loginSuccess1() {
        User user = new User().setEmail("svngdv@gmail.com").setPassword("A123456789a@");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

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

    // ========= HW 6 Negative Test =========
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("svngdvgmail.com", "A123456789a@"); // svngdv@gmail.com == svngdvgmail.com
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isWrongEmail(),"It'snot look like email"); //var -1




    }

    @Test
    public void loginEmptyEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("", "123456789a"); // A123456789a@ == 123456789a
        app.getHelperUser().submit();
        //Email is required
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtenNotActive());
    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("svngdv@gmail.com", "123456789a"); // A123456789a@ == 123456789a
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isWrongPassword(),"Wrong email or password");
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    @Test
    public void loginEmptyPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("svngdv@gmail.com", "");
        app.getHelperUser().submit();
        //Password is required
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtenNotActive());
        app.getHelperUser().pause(10000);
    }

    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("unregistered1999999user+test@gmail.com", "A123456789a@");
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isWrongPassword(), "Wrong email or password");
        app.getHelperUser().pause(10000);
    }


    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }

}
