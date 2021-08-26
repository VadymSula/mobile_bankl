package core;

import config.PropertiesConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class InitialDriver {
    private static final String APPIUM_URL = "http://0.0.0.0:4723/wd/hub";
    private static final Logger LOGGER = LoggerFactory.getLogger(InitialDriver.class);
    static AppiumDriver<MobileElement> driver;
    static DesiredCapabilities caps = new DesiredCapabilities();

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            try {
                driver = initializeDriver();
                LOGGER.info("Driver is started");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    private static AppiumDriver<MobileElement> initializeDriver() throws MalformedURLException {
        setCapabilities();
        return new AppiumDriver<>(new URL(APPIUM_URL), caps);
    }

    private static void setCapabilities() {
        switch (PropertiesConfig.getProperty("platformName").toUpperCase()) {
            case "ANDROID":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesConfig.getProperty("deviceName"));
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesConfig.getProperty("platformName"));
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesConfig.getProperty("platformVersion"));
                caps.setCapability(MobileCapabilityType.NO_RESET, false);
                caps.setCapability("autoGrandPermission", true);
                caps.setCapability("appPackage", PropertiesConfig.getProperty("myAppPackage"));
                caps.setCapability("appActivity", PropertiesConfig.getProperty("myAppActivity"));
                break;
            case "IOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesConfig.getProperty("iosDeviceName"));
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesConfig.getProperty("iosPlatformName"));
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesConfig.getProperty("iosPlatformVersion"));
                caps.setCapability(MobileCapabilityType.NO_RESET, true);
                caps.setCapability(MobileCapabilityType.UDID, PropertiesConfig.getProperty("iosUdId"));
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesConfig.getProperty("iosAutomationName"));
                caps.setCapability("bundleId", PropertiesConfig.getProperty("iosBundleId"));
                break;
            default:
                LOGGER.info("Driver is not initialize");
                break;
        }
    }
}
