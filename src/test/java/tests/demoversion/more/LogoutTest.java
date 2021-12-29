package tests.demoversion.more;

import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends DemoVersionMainTest {

    @Test
    public void logoutTest() {
        var actualResult = demoAccountPage
                .goToMorePage()
                .tapOnLogout()
                .isDisplayStartPage();

        Assert.assertTrue(actualResult);
    }
}
