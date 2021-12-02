package demoversion.paymentsAndTransfers.payments;

import demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InternetAndTVByVendorFromListTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("27932")
    public void internetAndTVByVendorFromListPaymentTest() {
        var actualResult = paymentsAndTransfersPage
                .tapOnInternetAndTVButton()
                .tapOnByVendorPAOButton()
                .fillInFields("9923491935", "110.15")
                .tapOnNextButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
