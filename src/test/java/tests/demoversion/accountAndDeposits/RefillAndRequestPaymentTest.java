package tests.demoversion.accountAndDeposits;

import io.qameta.allure.TmsLink;
import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@TmsLink("31841")
public class RefillAndRequestPaymentTest extends DemoVersionMainTest {

    @Test
    public void refillAndRequestPayment() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnRefillButton()
                .tapOnRequestPaymentButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
