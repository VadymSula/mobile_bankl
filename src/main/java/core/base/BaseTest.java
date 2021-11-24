package core.base;

import core.InitialDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import utils.mobile.Listener;

@Listeners(Listener.class)
public class BaseTest {
    private final AndroidDriver<MobileElement> androidDriver = (AndroidDriver<MobileElement>) InitialDriver.getDriver();
    protected AndroidBasePage androidBasePage = new AndroidBasePage((AndroidDriver<MobileElement>) InitialDriver.getDriver());

    @AfterClass
    public void afterMobileTests() {
        getAndroidDriver().resetApp();
    }

//    @AfterSuite
//    public void afterSuiteTest() {
//        getAppiumDriver().removeApp(PropertiesConfig.getProperty("myAppPackage"));
//    }

    public AndroidDriver<MobileElement> getAndroidDriver() {
        return androidDriver;
    }
}
