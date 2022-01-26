package tests.demoversion.accountAndDeposits;

import io.qameta.allure.TmsLink;
import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@TmsLink("31839")
public class RefillWithCardOtherBankTest extends DemoVersionMainTest {
    private static final String CVV_CODE = "191";
    private static final String SUM = "123";

    @Test
    public void refillWithCardOfOtherBank() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnRefillButton()
                .tapOnFromCardOfOtherBankButton()
                .tapOnTheClassicCard()
                .toFillCvvOnField(CVV_CODE)
                .toFillSumOnField(SUM)
                .tapOnTheNextButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
