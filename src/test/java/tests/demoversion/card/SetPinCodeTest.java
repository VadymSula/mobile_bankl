package tests.demoversion.card;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.card.DemoCardPage;
import tests.demoversion.DemoVersionMainTest;

public class SetPinCodeTest extends DemoVersionMainTest {

    @Test
    public void setPinCodeOnCardTest() {
        var actualResult = demoAccountPage
                .goToAccountPage()
                .tapOnCardWithoutPinCode()
                .scrollToActionsBlock()
                .tapOnSetPinCodeButton()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        var isDisplayActionsBlock = new DemoCardPage().isDisplayActionsBlock();
        Assert.assertTrue(actualResult && isDisplayActionsBlock);
    }
}
