package tests.demoversion.card;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.demoversion.DemoVersionMainTest;

public class CashBackTest extends DemoVersionMainTest {

    @Test
    public void cashBackDetailConditionsTest() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithPinCode()
                .scrollAndTapOnDetailsCashBackConditions()
                .scrollAndTapOnDetailConditions();

        Assert.assertTrue(actualResult);
    }
}
