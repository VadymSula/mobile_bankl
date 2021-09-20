package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import utils.mobile.Waiters;

import java.time.Duration;

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

    public void tapWithLongPressPerSecond(MobileElement mobileElement, Long durationInSec) {
        getActionFromLongPress(mobileElement, durationInSec).perform();
    }

    private TouchAction<?> getActionFromLongPress(MobileElement mobileElement, Long durationInSec) {
        return new TouchAction<>(driver).longPress(LongPressOptions
                .longPressOptions()
                .withDuration(Duration.ofSeconds(durationInSec))
                .withElement(ElementOption.element(mobileElement))
        );
    }
}
