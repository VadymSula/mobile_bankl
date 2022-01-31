package tests.demoversion.card;

import pages.android.demoversion.card.DemoCardPage;
import tests.demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditPinCodeTest extends DemoVersionMainTest {

    @Test
    public void editPinCodeForCardWithCode() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithPinCode()
                .scrollAndTapOnEditPinCode()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        var isDisplayActionsBlock = new DemoCardPage(getAndroidDriver()).isDisplayActionsBlock();
        Assert.assertTrue(actualResult && isDisplayActionsBlock);
    }
}
