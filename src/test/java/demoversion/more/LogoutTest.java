package demoversion.more;

import demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends DemoVersionMainTest {

    @Test
    public void logoutTest() {
        var actualResult = accountPage
                .goToMorePage()
                .tapOnLogout()
                .isDisplayStartPage();

        Assert.assertTrue(actualResult);
    }
}
