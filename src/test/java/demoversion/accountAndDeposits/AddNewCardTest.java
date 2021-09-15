package demoversion.accountAndDeposits;

import demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.accountsAndDeposits.AccountRefillPage;

public class AddNewCardTest extends DemoVersionMainTest {
    private final AccountRefillPage accountRefillPage = new AccountRefillPage(getAppiumDriver());

    @Test
    public void refillWithCardFromOtherBank_AddNewCard() {
        var actualResult = accountRefillPage
                .goToAccountRefill()
                .tapOnRefillButton()
                .tapOnFromCardOfOtherBankButton()
                .tapOnTheAddNewCardButton()
                .isExistAlertAboutNotAvailableInDemoVersion();

        Assert.assertTrue(actualResult);
    }
}
