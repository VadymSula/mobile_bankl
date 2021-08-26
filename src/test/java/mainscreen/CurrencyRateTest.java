package mainscreen;

import core.InitialDriver;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.mainscreen.CurrencyRatePage;

public class CurrencyRateTest {
    private final CurrencyRatePage currencyRatePage = new CurrencyRatePage(InitialDriver.getDriver());

    @Test
    @TmsLink("C9445")
    public void currencyRates() {
        var actualResult = currencyRatePage
                .goToCurrencyRatesPage()
                .isExistCurrencyRatesRecyclerOnPage();

        Assert.assertTrue(actualResult);
    }
}
