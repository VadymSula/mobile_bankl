package tests.demoversion.more;

import io.qameta.allure.Flaky;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.demoversion.more.DemoDepartmentAddressesPage;

public class DepartmentAddressesTest extends MoreMainTest {

    @Test
    @Flaky
    @TmsLink("24528")
    public void isDisplayCityMap() {
        var actualResult = demoMorePage
                .tapOnDepartmentAddresses()
                .isDisplayMapCity();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    @Flaky
    public void isDisplayListOfAddresses() {
        var departmentAddressesPage = new DemoDepartmentAddressesPage();
        var actualResult = departmentAddressesPage
                .tapOnListOfAddresses()
                .isDisplayListOfAddresses();

        Assert.assertTrue(actualResult);
    }
}
