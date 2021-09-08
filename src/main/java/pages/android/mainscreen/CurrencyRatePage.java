package pages.android.mainscreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import core.base.AndroidBasePage;

public class CurrencyRatePage extends AndroidBasePage {
    @AndroidFindBy(id = "cb.ibank:id/view_controller_currency_rates_recycler")
    protected MobileElement CURRENCY_RATES_RECYCLER;

    public CurrencyRatePage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public boolean isExistCurrencyRatesRecyclerOnPage() {
        return elements.isElementExist(CURRENCY_RATES_RECYCLER);
    }
}
