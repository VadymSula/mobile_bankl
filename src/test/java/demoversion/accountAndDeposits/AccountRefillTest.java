package demoversion.accountAndDeposits;

import demoversion.DemoVersionMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

@TmsLink("C12618")
public class AccountRefillTest extends DemoVersionMainTest {
    private static final String TRANSFER_SUM = "2000";

    @Test
    public void isExistBeforeSelectedAccountTest() {
        accountPage
                .goToAccountPage()
                .tapOnRefillButton()
                .tapOnFromMyAccountButton();
        var actualResult = accountPage.isExistSelectedAccount();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void toTransferSum() {
        var actualResult = accountPage
                .tapOnTransferFromAccountSender()
                .chooseDepositAccountCheckbox()
                .inputSumForTransfer(TRANSFER_SUM)
                .tapOnTransferButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }

}
