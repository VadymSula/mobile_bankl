package pages.android.demoversion.card.limits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoLimitsPage extends DemoVersionMainPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Все расходы в месяц')]/..")
    protected MobileElement ALL_EXPENSES_PER_MONTH_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_limits_fab")
    protected MobileElement ADD_LIMIT;

    public DemoLimitsPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть на 'Все расходы в месяц'")
    public DemoLimitManagementPage tapOnAllExpensesPerMonthButton() {
        buttons.searchAndClickButtonBy(ALL_EXPENSES_PER_MONTH_BUTTON);
        return new DemoLimitManagementPage(getAndroidDriver());
    }

    @Step("Тапнуть на 'Добавить'")
    public DemoLimitsPage tapOnAddLimitButton() {
        buttons.searchAndClickButtonBy(ADD_LIMIT);
        return this;
    }
}
