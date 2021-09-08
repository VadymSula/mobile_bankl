package mainscreen;

import core.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.mainscreen.BecomeClientPage;

public class BecomeClientTest extends BaseTest {
    private final BecomeClientPage becomeClientPage = new BecomeClientPage(getAppiumDriver());

    @Test
    public void toBecomeClient() {
        var actualResult = becomeClientPage
                .goToBecomeClientPage()
                .isExistBecomeClientContainer();

        Assert.assertTrue(actualResult);
    }
}
