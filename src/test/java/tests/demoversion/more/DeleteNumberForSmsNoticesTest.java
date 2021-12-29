package tests.demoversion.more;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNumberForSmsNoticesTest extends MoreMainTest {

    @Test
    public void deleteNumberForSmsNotificationsTest() {
        var actualResult = demoMorePage
                .tapOnSmsAndEmailNotifications()
                .tapOnDeleteFirstNumber()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
