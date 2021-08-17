package elements;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Waiters;

public class Elements {
    private static final Logger LOGGER = LoggerFactory.getLogger(Elements.class);
    private Waiters waiters;


    public String getTextFromElement(MobileElement mobileElement) {
        waiters.waitForElementVisibleNot(mobileElement);
        return mobileElement.getText();
    }

    public boolean isSelectedElement(MobileElement mobileElement) {
        try {
            mobileElement.isSelected();
            return true;
        } catch (Exception ElementNotSelected) {
            LOGGER.error("Element " + mobileElement.toString() + " is not selected");
            return false;
        }
    }

    public boolean isVisibleElement(MobileElement mobileElement) {
        try {
            waiters.waitForVisibility(mobileElement);
            return true;
        } catch (Exception ElementNotVisible) {
            LOGGER.error("Element " + mobileElement.toString() + " is not visible");
            return false;
        }
    }

    public boolean isNotVisibleElement(MobileElement mobileElement) {
        try {
            waiters.waitForVisibility(mobileElement);
            return true;
        } catch (Exception ElementNotVisible) {
            LOGGER.error("Element " + mobileElement.toString() + " is not visible");
            return false;
        }
    }

    public void searchFieldAndSendKey(MobileElement mobileElement, String key) {
        var searchField = waiters.waitForElementClickable(mobileElement);
        searchField.sendKeys(key);
    }
}
