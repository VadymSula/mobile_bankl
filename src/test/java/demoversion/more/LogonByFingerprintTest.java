package demoversion.more;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogonByFingerprintTest extends MoreMainTest {

    @Test
    @TmsLink("26662")
    public void logonByFingerprint() {
        var actualResult = morePage
                .tapOnLogonByFingerprintToggle()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
