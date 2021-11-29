package demoversion.paymentsAndTransfers.payments;

import demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MobileConnectionTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13089")
    @Parameters({"phoneNumber", "sum"})
    public void mobileConnectionTest(String phoneNumber, String sum) {
        var actualResult = paymentsAndTransfersPage
                .tapOnMobileConnectionButton()
                .inputPhoneNumberInField(phoneNumber)
                .tapOnNewPhoneNumberButton()
                .fillOnSumField(sum)
                .tapOnTransferButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
