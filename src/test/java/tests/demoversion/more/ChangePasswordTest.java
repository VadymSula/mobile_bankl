package tests.demoversion.more;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends MoreMainTest {

    @Test
    public void changePasswordTest() {
        var actualResult = demoMorePage
                .tapOnChangePassword()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
