package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    public class LoginTests extends TestBase {

        @BeforeMethod
        public void preCondition() {
            //if button ' Logout ' present == click to ' Logout ' for check all tests
            if (app.getHelperUser().isLogged()) {
                app.getHelperUser().logout();
            }
        }


    }

    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000); //random for 1 and 999 for registration
        System.out.println(i); //sout

        System.out.println(System.currentTimeMillis());  // system for discount measure time to millisecond
        int z = Math.toIntExact((System.currentTimeMillis() / 1000 % 3600));  //chose long for int == chose to System.currentTimeMillis()/1000%3600 --> right button mice --> Adept using "Match to intExact"

        User user = new User()
                .setFirstName("Disa")
                .setLastName("Know")
                .setEmail("know"+z+"@gmail.com")
                .setPassword("Kknow123456@");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();   // method use HelperUser
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }
}
