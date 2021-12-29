package tests.demoversion.more;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.more.DemoPersonalDataPage;

public class PersonalDataTest extends MoreMainTest {

    @Test
    public void showPersonalDataTest() {
        var actualResult = demoMorePage
                .tapOnPersonalData()
                .tapOnCodeWordButton()
                .tapOnShowCodeWord()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void editPersonalDataTest() {
        var actualResult = new DemoPersonalDataPage(getAndroidDriver())
                .tapOnEditCodeWord()
                .isExistAlertAboutNotAvailableInDemoVersionAndTapOK();

        Assert.assertTrue(actualResult);
    }
}
