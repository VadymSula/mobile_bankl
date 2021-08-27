package mainscreen;

import core.InitialDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.mainscreen.BecomeClientPage;

public class BecomeClientTest {
    private final BecomeClientPage becomeClientPage = new BecomeClientPage(InitialDriver.getDriver());

    @Test
    public void toBecomeClient() {
        var actualResult = becomeClientPage
                .goToBecomeClientPage()
                .isExistBecomeClientContainer();

        Assert.assertTrue(actualResult);
    }
}
