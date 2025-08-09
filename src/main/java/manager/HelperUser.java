package manager;

import models.User;
import org.openqa.selenium.*;

//Public class HelperUser added extends HelperBase and root super
//public class HelperUser extends HelperBase click to right mice button and chose to Create constructor matching super
public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        // ========================  Var1 ===================================
        //WebElement loginTab = wd.findElement(By.xpath("//href[text()='Log in']")); //Var1
        //        WebElement loginTab2 = wd.findElement(By.cssSelector("a[href='login']"));  //Var2
        //        loginTab2.click();
        // ========================  Var2 ===================================
        //click(By.cssSelector("a[href='login']"));
        click(By.xpath("//a[text()=' Log in ']"));

    }

    //Method have take to (String email, String password)
    public void fillLoginForm(String email, String password) {
        // ========================  Var1 ===================================
        //        WebElement emailInput = wd.findElement(By.id("email"));
        //        emailInput.click();
        //        emailInput.clear();
        //        emailInput.sendKeys(email);
        // ========================  Var2 ===================================
//        WebElement passwordInput = wd.findElement(By.id("password"));
//        //WebElement confirm = wd.findElement(By)
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);

        type(By.id("email"), email); // method HelperBase
        type(By.id("password"), password);

    }

    //Over Loading
    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail()); // method HelperBase
        type(By.id("password"), user.getPassword());
    }

    public void submit(){
        //click(By.xpath("//button[text()='Y’alla!']"));  - NO USE Element 'Y’alla!' no find!
        click(By.xpath("//*[@type='submit']"));
    }

    public void clickOkButton(){
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
    return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public String getMessage() {

        //pause(2000);  //use new method pause(int time) == HelperBase
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText(); //variant 1

        // ==============================Variant 2 ==========================================
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
    }

    // ========================= REGISTRATION FORM ====================================

    public void openRegistrationForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
    }


    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void checkPolicy() {
        //click(By.id("terms-of-use")); //var1 no worked
        //click(By.xpath("label[@for='terms-of-use']")); //var2 no worked

        //Check box use for java // Var 3
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");
    }
}
