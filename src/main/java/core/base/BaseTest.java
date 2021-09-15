package core.base;

import config.PropertiesConfig;
import core.InitialDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import utils.mobile.Listener;

@Listeners(Listener.class)
public class BaseTest {
    private final AppiumDriver<MobileElement> appiumDriver = InitialDriver.getDriver();

    @AfterClass
    public void afterMobileTests() {
        getAppiumDriver().resetApp();
    }

//    @AfterSuite
//    public void afterSuiteTest() {
//        getAppiumDriver().removeApp(PropertiesConfig.getProperty("myAppPackage"));
//    }

    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }
}
