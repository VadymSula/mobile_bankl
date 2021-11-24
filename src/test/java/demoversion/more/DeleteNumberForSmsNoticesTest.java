package demoversion.more;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNumberForSmsNoticesTest extends MoreMainTest {

    @Test
    public void deleteNumberForSmsNotificationsTest() {
        var actualResult = morePage
                .tapOnSmsAndEmailNotifications()
                .tapOnDeleteFirstNumber()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
