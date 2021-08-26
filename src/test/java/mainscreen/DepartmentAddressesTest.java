package mainscreen;

import core.InitialDriver;
import io.qameta.allure.Flaky;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.mainscreen.DepartmentAddressesPage;
import utils.GPSTools;

public class DepartmentAddressesTest {
    private final DepartmentAddressesPage addressesPage = new DepartmentAddressesPage(InitialDriver.getDriver());

    @BeforeClass
    public void installGPSTools() {
        GPSTools.switchOffGPSConnection("C:/Users/AndUser/AppData/Local/platform-tools", "a32042dd");
    }

    @Test
    @Flaky
    @TmsLink("C9444")
    public void departmentAndATMAddresses() {
        var actualResult = addressesPage
                .goToDepartmentAddressesPage()
                .goToAddressDepartmentToSingleVariant()
                .tapOnArrowButton()
                .isDisplayedAdditionalInfo();

        Assert.assertTrue(actualResult);
    }
}
