package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

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
        if(isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
    return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public String getMessage() {

        pause(2000);  //use new method pause(int time) == HelperBase
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText(); //variant 1

        // ==============================Variant 2 ==========================================
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
    }
    public boolean isWrongEmail(){
        return isElementPresent(By.xpath("//div[normalize-space(.)=\"It'snot look like email\"]"));
    }

    public boolean isWrongPassword() {
        return isElementPresent(By.xpath(
                "//*[contains(text(),'Wrong email or password') or contains(text(),'Login or Password incorrect')]"
        ));
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
    //var3 checkbox
    public void checkPolicyXY() {
        if(!wd.findElement(By.id("terms-of-use")).isSelected()) {
            WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
            Rectangle rect = label.getRect();
            int w = rect.getWidth();

            // Dimension size = wd.manage().window().getSize();

            int xOffSet = -w / 2;
            Actions actions = new Actions(wd);
            actions.moveToElement(label, xOffSet, 0).click().release().perform();
        }
    }

    public String getErrorText() {
    return wd.findElement(By.cssSelector("div.error")).getText();
    }
}
