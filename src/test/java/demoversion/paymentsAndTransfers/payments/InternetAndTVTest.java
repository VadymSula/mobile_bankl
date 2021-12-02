package demoversion.paymentsAndTransfers.payments;

import demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InternetAndTVTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13094")
    public void internetAndTVPaymentsTest() {
        var actualResult = paymentsAndTransfersPage
                .tapOnInternetAndTVButton()
                .tapOnByQRCodePaymentButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
