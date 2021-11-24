package demoversion.paymentsAndTransfers.transfers;

import demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ByCardNumberTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13085")
   // @Parameters({"cardNumber", "sum", "comment"})
    public void paymentAndTransferByCardNumberTest(/*String cardNumber, String sum, String comment*/) {
        var actualResult = paymentsAndTransfersPage
                .tapOnByCardNumberButton()
                .fillInFieldsForTransferByCardNumber("1600 4522 5555 2000", "1234.56", "qwerty")
                .tapOnTransferButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
