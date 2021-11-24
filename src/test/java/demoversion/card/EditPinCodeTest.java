package demoversion.card;

import demoversion.DemoVersionMainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditPinCodeTest extends DemoVersionMainTest {

    @Test
    public void editPinCodeForCardWithCode() {
        var actualResult = accountPage
                .goToAccountPage()
                .tapOnCardWithPinCode()
                .scrollAndTapOnEditPinCode()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
