package demoversion.accountAndDeposits;

import core.InitialDriver;
import demoversion.DemoVersionMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.accountsAndDeposits.AccountRefillPage;

@TmsLink("C12618")
public class AccountRefillTest extends DemoVersionMainTest {
    private static final String TRANSFER_SUM = "2000";
    private final AccountRefillPage accountRefillPage = new AccountRefillPage(InitialDriver.getDriver());

    @Test
    public void isExistBeforeSelectedAccountTest() {
        accountRefillPage
                .goToAccountRefill()
                .tapOnRefillButton()
                .tapOnFromMyAccountButton();
        var actualResult = accountRefillPage.isExistSelectedAccount();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void toTransferSum() {
        accountRefillPage
                .tapOnTransferFromAccountSender()
                .chooseDepositAccountCheckbox()
                .inputSumForTransfer(TRANSFER_SUM)
                .tapOnTransferButton();
    }

}
