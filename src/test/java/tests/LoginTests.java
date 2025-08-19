package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finished logout");  // logger added for BeforeMethod
        }
    }

    @Test
    public void loginSuccess1() {
        logger.info("Start test with name ==> 'loginSuccess1'"); //var 1 for hand will forma logger
        logger.info("Test data ==> email: 'svngdv@gmail.com' & password: 'A123456789a@'");
        User user = new User().setEmail("svngdv@gmail.com").setPassword("A123456789a@");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("End test with name ==> 'loginSuccess1'"); //var 1 for hand will forma logger
        logger.info("Assert check in Element button 'Sign out' present");
    }


    @Test
    public void loginSuccess() {
        logger.info("Test data ==> email: 'svngdv@gmail.com' & password: 'A123456789a@'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("svngdv@gmail.com", "A123456789a@");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("Assert check in Element button 'Sign out' present");
    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data ==> email: 'svngdv@gmail.com' & password: 'A123456789a@'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("svngdv@gmail.com", "A123456789a@");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("Assert check in Element button 'Sign out' present");
    }

    @Test
    public void loginWrongEmail() {
        logger.info("Test data ==> email: 'svngdvgmail.com' & password: 'A123456789a@'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("svngdvgmail.com", "A123456789a@");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check in Alert present with error text 'It'snot look like email'");
    }

    @Test
    public void loginEmptyEmail() {
        logger.info("Test data ==> email: '' & password: 'A123456789a@'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("", "A123456789a@");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check in Alert present with error text 'Email is required'");
    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test data ==> email: 'svngdv@gmail.com' & password: '1234'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("svngdv@gmail.com", "1234"); //A123456789a@
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check in Alert present with error text 'Login or Password incorrect'");
    }

    @Test
    public void loginEmptyPassword() {
        logger.info("Test data ==> email: 'svngdv@gmail.com' & password: ''");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("svngdv@gmail.com", ""); //A123456789a@
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check in Alert present with error text 'Password is required'");
    }

    @Test
    public void loginUnregistered() {
        logger.info("Test data ==> email: 'svngdv1111@gmail.com' & password: 'A123456789a@'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("svngdv1111@gmail.com", "A123456789a@");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check in Alert present with error text 'Login or Password incorrect'");
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }

}