package core.base;

import core.InitialDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

//TODO не уверен! @Listeners(Listener.class)
public class BaseStep {
    private static final AndroidDriver<MobileElement> androidDriver = (AndroidDriver<MobileElement>) InitialDriver.getDriver();
    protected static AndroidBasePage androidBasePage = new AndroidBasePage((AndroidDriver<MobileElement>) InitialDriver.getDriver());

    public static AndroidDriver<MobileElement> getAndroidDriver() {
        return androidDriver;
    }
}
