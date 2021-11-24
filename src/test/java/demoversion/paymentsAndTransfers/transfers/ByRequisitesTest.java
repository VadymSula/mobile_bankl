package demoversion.paymentsAndTransfers.transfers;

import demoversion.paymentsAndTransfers.PaymentsAndTransfersMainTest;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.paymensAndTransfers.entity.Requisites;

public class ByRequisitesTest extends PaymentsAndTransfersMainTest {

    @Test
    @TmsLink("13086")
    public void paymentByAccountRequisitesTest() {
        var requisites = new Requisites(
                "Иванов Иван Иванович",
                "12345678900987654321",
                "1234567890",
                "123456789",
                "Перевод по реквизитам/счету",
                "1500.56"
        );

        var actualResult = paymentsAndTransfersPage
                .tapOnByRequisitesButton()
                .fillInFields(requisites, "ПАО")
                .tapOnTransferButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
