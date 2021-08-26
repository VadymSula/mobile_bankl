package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.ElementNotVisibleException;
import utils.Waiters;

public class Buttons extends MobileElements {

    public Buttons(AppiumDriver<MobileElement> driver, Waiters waiters) {
        super(driver, waiters);
    }

    public void searchAndClickButtonBy(MobileElement mobileElement) {
        var waitedMobileElement = waiters.waitForElementClickable(mobileElement);
        waitedMobileElement.click();
    }
    public void waitInSecondsAndClickButtonBy(MobileElement mobileElement, Integer quantityOfSeconds) {
        waiters.waitSomeSecond(quantityOfSeconds);
        mobileElement.click();
    }

    public void clickButtonBackOnKeyboardAndroid(AndroidDriver<MobileElement> androidDriver) {
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
