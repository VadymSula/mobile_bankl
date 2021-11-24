package demoversion.more;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.more.FastPaymentSystemPage;

public class FastPaymentSystemTest extends MoreMainTest {

    @Test
    public void isDisplayedInfoFromAlertSBP() {
        var actualResult = morePage
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
        var actualResult = new FastPaymentSystemPage(getAndroidDriver())
                .tapOnOkButtonAndGoToSBP()
                .tapOnAgreeConditionsCheckbox()
                .tapOnConnectButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
