package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    //Created static ApplicationManager for link
    static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        app.init(); //methods for ApplicationManager link == app
    }

    @AfterSuite
    public void tearDown() {
        //app.stop(); //methods for ApplicationManager link == app
    }
}
