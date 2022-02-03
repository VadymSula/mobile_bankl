package core;

import config.PropertiesConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.YamlParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class InitialDriver {
    private static final String APPIUM_URL = "http://0.0.0.0:4723/wd/hub";
    private static final Logger LOGGER = LoggerFactory.getLogger(InitialDriver.class);
    private static final YamlParser yamlParser = new YamlParser();
    static AppiumDriver<MobileElement> driver;
    static DesiredCapabilities caps = new DesiredCapabilities();

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            try {
                driver = initializeDriver();
                driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
                LOGGER.info("Driver is started");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    private static AppiumDriver<MobileElement> initializeDriver() throws MalformedURLException {
            setCapabilities();
            switch (caps.getPlatform()) {
                case ANDROID:
                    return new AndroidDriver<>(new URL(APPIUM_URL), caps);
                case IOS:
                    return new IOSDriver<>(new URL(APPIUM_URL), caps);
                default:
                    LOGGER.error("Invalid platform");
            }
            return null;
    }

    private static void setCapabilities() {
        var capabilities = yamlParser.getCapabilitiesForDevice("realme6Pro");
        switch (capabilities.getDevice().getDeviceName()) {
            case "realme6Pro":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, capabilities.getDevice().getDeviceName());
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, capabilities.getDevice().getPlatformName());
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, capabilities.getDevice().getPlatformVersion());
                caps.setCapability(MobileCapabilityType.NO_RESET, false);
                caps.setCapability("autoGrantPermission", true);
                caps.setCapability("appActivity", capabilities.getMyAppActivity());
                caps.setCapability("appPackage", capabilities.getMyAppPackage());
                break;
            case "IOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesConfig.getProperty("iosDeviceName"));
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesConfig.getProperty("iosPlatformName"));
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesConfig.getProperty("iosPlatformVersion"));
                caps.setCapability(MobileCapabilityType.NO_RESET, false);
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
