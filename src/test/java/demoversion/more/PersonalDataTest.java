package demoversion.more;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalDataTest extends MoreMainTest {

    @Test
    public void showPersonalDataTest() {
        var actualResult = morePage
                .tapOnPersonalData()
                .tapOnCodeWordButton()
                .tapOnShowCodeWord()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void editPersonalDataTest() {
        morePage.tapOnOkButton();

        var actualResult = morePage
                .tapOnChangePassword()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
