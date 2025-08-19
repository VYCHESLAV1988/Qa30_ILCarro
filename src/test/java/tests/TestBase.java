package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class); // Logger added labery for class TestBase
    static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    //Method for logger var2  chose to method for  startLogger == ( Method.java.land.reflect ) !!!
    public void startLogger(Method m){
      logger.info("Name of method ==>" + m.getName());
    }

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        //app.stop();
    }
}