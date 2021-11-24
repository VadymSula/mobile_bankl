package demoversion.card;

import demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CashBackTest extends DemoVersionMainTest {

    @Test
    public void cashBackDetailConditionsTest() {
        var actualResult = accountPage
                .goToAccountPage()
                .tapOnCardWithPinCode()
                .scrollAndTapOnDetailsCashBackConditions()
                .scrollAndTapOnDetailConditions()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
