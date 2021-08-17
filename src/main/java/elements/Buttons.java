package elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.Waiters;

public class Buttons {
    private Waiters waiters;

    public void searchAndClickButtonBy(MobileElement mobileElement) {
        var waitedMobileElement = waiters.waitForElementClickable(mobileElement);
        waitedMobileElement.click();

    }
    public void clickButtonBackOnKeyboardAndroid(AndroidDriver<MobileElement> androidDriver) {
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
