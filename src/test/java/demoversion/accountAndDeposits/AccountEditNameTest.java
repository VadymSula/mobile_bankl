package demoversion.accountAndDeposits;

import demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountEditNameTest extends DemoVersionMainTest {

    @Test
    public void editAccountName() {
        var actualResult = accountPage
                .goToAccountPage()
                .tapOnEditNameButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
