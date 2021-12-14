package demoversion.paymentsAndTransfers.transfers;

import demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ByPhoneNumberTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13083")
    @Parameters("sumForTransfer")
    public void paymentByPhoneNumberTest(String sumForTransfer) {
        var actualResult = paymentsAndTransfersPage
                .tapOnByPhoneNumberButton()
                .tapOnPhoneNumber()
                .tapOnRecipientSectionOnUBRiRTransfer()
                .inputSumInFieldForTransfer(sumForTransfer)
                .tapOnTransferButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
