package tests.demoversion.accountAndDeposits;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.demoversion.DemoVersionMainTest;

public class CertificateAvailableResidueTest extends DemoVersionMainTest {

    @Test
    @TmsLink("31845")
    //@Parameters("email")
    public void certificateOfAvailableResidue(/*String email*/) {

        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCertificateAvailableResidue()
                .fillTheEmailField("asdasd@gmail.com")
                .tapOnSendButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
