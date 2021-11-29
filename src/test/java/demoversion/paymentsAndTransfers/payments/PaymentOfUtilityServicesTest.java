package demoversion.paymentsAndTransfers.payments;

import demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentOfUtilityServicesTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13091")
    public void paymentsOfUtilityServicesTest() {
        var actualResult = paymentsAndTransfersPage
                .tapOnPaymentOfUtilityServices()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
