package tests.demoversion.accountAndDeposits;

import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountEditNameTest extends DemoVersionMainTest {

    @Test
    public void editAccountName() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnEditNameButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
