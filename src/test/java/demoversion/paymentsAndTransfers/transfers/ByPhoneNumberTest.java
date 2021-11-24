package demoversion.paymentsAndTransfers.transfers;

import demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByPhoneNumberTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13083")
    public void paymentByPhoneNumberTest() {
        var actualResult = paymentsAndTransfersPage
                .tapOnByPhoneNumberButton()
                .tapOnPhoneNumber()
                .tapOnRecipientSectionOnUBRiRTransfer()
                .inputSumInFieldForTransfer("10000")
                .tapOnTransferButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
