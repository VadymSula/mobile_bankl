package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.AppiumFunction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.testng.Assert.fail;

public class Waiters {
    protected static final Logger LOGGER = LoggerFactory.getLogger(Waiters.class);

    protected static final long WAIT_ELEMENT_TIMEOUT_IN_SECONDS = 10L;
    protected static final long WAIT_ELEMENT_NOT_EXIST_TIMEOUT_IN_SECONDS = 1L;

    AppiumDriver<MobileElement> driver;

    public Waiters(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void waitForAlert() {
        waiter().until(ExpectedConditions.alertIsPresent());
    }

    public MobileElement getElementAfterWaitForVisibility(MobileElement mobileElement) {
        return (MobileElement) waiter().until(ExpectedConditions.visibilityOf(mobileElement));
    }

    public void waitForVisibility(MobileElement mobileElement) {
        waiter().until(ExpectedConditions.visibilityOf(mobileElement));
    }

    public MobileElement waitForElementClickable(MobileElement element) {
        return (MobileElement) waiter().until(elementToBeClickable(element));
    }

    public void waitForChangeAttribute(By by, String attribute, String attributeValue) {
        waiter().until(ExpectedConditions.attributeContains(by, attribute, attributeValue));
    }

    public void waitForElementVisibleNot(By byElement) {
        waitUntilFunctionIsTrue(func -> !isElementExist(byElement));
    }

    public void waitForElementVisibleNot(MobileElement element) {
        waitUntilFunctionIsTrue(func -> !isElementExist(element));
    }

    public boolean isElementExist(By locator) {
        var allElements = driver.findElements(locator);
        return allElements != null && !allElements.isEmpty();
    }

    public boolean isElementExist(MobileElement element) {
        boolean isElementExist;
        setWaitElementTimeout(WAIT_ELEMENT_NOT_EXIST_TIMEOUT_IN_SECONDS);

        try {
            isElementExist = element.isDisplayed();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            isElementExist = false;
        }

        setWaitElementTimeout(WAIT_ELEMENT_TIMEOUT_IN_SECONDS);
        return isElementExist;
    }

    public void waitUntilFunctionIsTrue(AppiumFunction<AppiumDriver<MobileElement>, Object> function) {
        waiter().until(function);
    }

    protected void waitUntilFunctionIsTrue(AppiumFunction<AppiumDriver<MobileElement>, Object> function, String errorMessage) {
        waiter(errorMessage).until(function);
    }

    protected void waitForPageVisible(MobileElement element) {
        var pageName = getClass().getSimpleName();
        LOGGER.info("Wait page: " + pageName);

        try {
            waitForVisibility(element);
        } catch (Exception e) {
            var errorMessage = pageName + " was not loaded after " + WAIT_ELEMENT_TIMEOUT_IN_SECONDS + " seconds.\n";
            fail(errorMessage);
            LOGGER.error(errorMessage);
            e.printStackTrace();
        }

        LOGGER.info("Page " + pageName + " loaded");
    }

    protected void waitForPageNotVisible(String rootPageLocator) {
        var pageName = getClass().getSimpleName();

        try {
            waitForElementVisibleNot(By.xpath(rootPageLocator));
        } catch (Exception e) {
            fail(pageName + " was not closed after " + WAIT_ELEMENT_TIMEOUT_IN_SECONDS + " seconds.\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private FluentWait<AppiumDriver<MobileElement>> waiter() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_ELEMENT_TIMEOUT_IN_SECONDS))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    private FluentWait<AppiumDriver<MobileElement>> waiter(String errorMessage) {
        return waiter()
                .withMessage(errorMessage + "\nWait timeout: " + WAIT_ELEMENT_TIMEOUT_IN_SECONDS + " seconds.\n");
    }

    public void waitSomeSecond(Integer seconds) {
        int timeOnMills = seconds * 1000;

        try {
            Thread.sleep(timeOnMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setWaitElementTimeout(long timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
    }
}

