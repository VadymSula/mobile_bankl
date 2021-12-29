package tests.demoversion.card;

import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CashBackTest extends DemoVersionMainTest {

    @Test
    public void cashBackDetailConditionsTest() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithPinCode()
                .scrollAndTapOnDetailsCashBackConditions()
                .scrollAndTapOnDetailConditions()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
