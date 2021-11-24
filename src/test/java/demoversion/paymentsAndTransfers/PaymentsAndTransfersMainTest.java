package demoversion.paymentsAndTransfers;

import core.base.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.android.demoversion.paymensAndTransfers.PaymentsAndTransfersPage;

public class PaymentsAndTransfersMainTest extends BaseTest {
    protected final PaymentsAndTransfersPage paymentsAndTransfersPage = new PaymentsAndTransfersPage(getAndroidDriver());

    @BeforeClass
    public void goToDemoVersionAndPayments() {
        androidBasePage
                .goToDemoVersion()
                .tapOnPaymentsButton();
    }
}
