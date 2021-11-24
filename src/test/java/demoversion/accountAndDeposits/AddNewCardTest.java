package demoversion.accountAndDeposits;

import demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCardTest extends DemoVersionMainTest {

    @Test
    public void refillWithCardFromOtherBank_AddNewCard() {
        var actualResult = accountPage
                .goToAccountPage()
                .tapOnRefillButton()
                .tapOnFromCardOfOtherBankButton()
                .tapOnTheAddNewCardButton()
                .isExistAlertAboutNotAvailableInDemoVersion();

        Assert.assertTrue(actualResult);
    }
}
