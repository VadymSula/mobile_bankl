package demoversion.paymentsAndTransfers.payments;

import demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByQRCodeTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13088")
    public void paymentByQRCodeTest() {
        var actualResult = paymentsAndTransfersPage
                .tapOnPaymentByQRCodeButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
