package elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.mobile.Waiters;

import java.time.Duration;

public class Screen extends MobileElements {
    private AppiumDriver<MobileElement> driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(Screen.class);

    public Screen(AppiumDriver<MobileElement> driver, Waiters waiters) {
        super(driver, waiters);
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public void scrollablePageAndroid(String text) {
        ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(" + "\"" + text + "\"" + ").instance(0));");
        LOGGER.info("Page is scrollable");
    }

    public void scrollablePageIOS(WebElement webElement) {
        TouchActions action = new TouchActions(driver);
        action.scroll(webElement, 10, 100);
        action.perform();
    }

    public void swipe(Direction dir) {
        final int ANIMATION_TIME = 200;
        final int PRESS_TIME = 200;
        int edgeBorder = 200;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = driver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            LOGGER.error("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
        }
    }
}
