package demoversion.more;

import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CallToBankTest extends MoreMainTest {

    @Test
    @TmsLink("24530")
    public void callToBankTest() {
        var actualResult = morePage
                .tapOnCallToBank()
                .isDisplayedCurtainWithCallSelect();

        Assert.assertTrue(actualResult);
    }
}
