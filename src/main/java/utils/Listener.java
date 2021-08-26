package utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

//public class Listener implements ITestListener {
//    @Override
//    public void onTestFailure(ITestResult result) {
//        Object currentClass = result.getInstance();
//        AppiumDriver<MobileElement> driver = ((BaseTest) currentClass).getAppiumDriver(); // BaseTest not implemented
//        var srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        saveScreenshot(srcFile);
//    }
//
//    @Attachment(value = "Page screenshot", type = "image/png")
//    private byte[] saveScreenshot(byte[] screenshot) {
//        return screenshot;
//    }
//}

