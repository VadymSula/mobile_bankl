package tests.demoversion.card;

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

        Assert.assertTrue(actualResult);
    }
}
