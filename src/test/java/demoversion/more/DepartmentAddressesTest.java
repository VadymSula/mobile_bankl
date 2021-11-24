package demoversion.more;

import io.qameta.allure.Flaky;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.more.DepartmentAddressesPage;

public class DepartmentAddressesTest extends MoreMainTest {

    @Test
    @Flaky
    @TmsLink("24528")
    public void isDisplayCityMap() {
        var actualResult = morePage
                .tapOnDepartmentAddresses()
                .isDisplayMapCity();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    @Flaky
    public void isDisplayListOfAddresses() {
        var departmentAddressesPage = new DepartmentAddressesPage(getAndroidDriver());
        var actualResult = departmentAddressesPage
                .tapOnListOfAddresses()
                .isDisplayListOfAddresses();

        Assert.assertTrue(actualResult);
    }
}
