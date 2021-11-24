package demoversion.card;

import demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetPinCodeTest extends DemoVersionMainTest {

    @Test
    public void setPinCodeOnCardTest() {
        var actualResult = accountPage
                .goToAccountPage()
                .tapOnCardWithoutPinCode()
                .scrollAndTapOnSetPinCodeButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
