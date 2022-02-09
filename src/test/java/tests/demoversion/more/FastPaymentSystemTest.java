package tests.demoversion.more;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.more.DemoFastPaymentSystemPage;

public class FastPaymentSystemTest extends MoreMainTest {

    @Test
    public void isDisplayedInfoFromAlertSBP() {
        var actualResult = demoMorePage
                .tapOnFastPaymentSystem()
                .tapOnHintAboutFastPaymentSystem()
                .tapOnCloseButton()
                .tapOnPhoneField()
                .tapOnOtherNumber()
                .tapOnSPBSettingsAccountHint()
                .isDisplayedInfoText();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void isNotAvailableInDemoVersion() {
        var actualResult = new DemoFastPaymentSystemPage()
                .tapOnOkButtonAndGoToSBP()
                .tapOnAgreeConditionsCheckbox()
                .tapOnConnectButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
