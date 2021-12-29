package tests.demoversion.card;

import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetPinCodeTest extends DemoVersionMainTest {

    @Test
    public void setPinCodeOnCardTest() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithoutPinCode()
                .scrollAndTapOnSetPinCodeButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
