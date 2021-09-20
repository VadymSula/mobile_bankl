package demoversion.accountAndDeposits;

import demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CertificateAvailableResidueTest extends DemoVersionMainTest {

    @Test
    @Parameters("email")
    public void certificateOfAvailableResidue(String email) {
        var actualResult = accountRefillPage
                .goToAccountRefill()
                .tapOnCertificateAvailableResidue()
                .fillTheEmailField(email)
                .tapOnAccountSelector()
                .tapOnFirstCheckboxFromAccounts()
                .tapOnSendButton()
                .isExistAlertAboutNotAvailableInDemoVersion();

        Assert.assertTrue(actualResult);
    }
}
