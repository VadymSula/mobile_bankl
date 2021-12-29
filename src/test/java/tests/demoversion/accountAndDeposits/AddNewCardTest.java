package tests.demoversion.accountAndDeposits;

import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCardTest extends DemoVersionMainTest {

    @Test
    public void refillWithCardFromOtherBank_AddNewCard() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnRefillButton()
                .tapOnFromCardOfOtherBankButton()
                .tapOnTheAddNewCardButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
