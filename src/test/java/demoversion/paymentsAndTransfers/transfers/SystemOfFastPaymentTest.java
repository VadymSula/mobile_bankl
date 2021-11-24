package demoversion.paymentsAndTransfers.transfers;

import demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SystemOfFastPaymentTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13087")
    public void systemOfFastPaymentsTest() {
        var actualResult = paymentsAndTransfersPage
                .tapOnSBPButton()
                .tapOnByPhoneNumberButtonThroughSBP()
                .fillInFieldsForSBP("1500.56", "тест №1")
                .tapOnTransferSBPButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
