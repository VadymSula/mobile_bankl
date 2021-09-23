package pages.android.demoversion.card;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;
import pages.android.demoversion.card.cashback.CashBackConditionsPage;

public class CardPage extends DemoVersionMainPage {

    @AndroidFindBy(id = "cb.ibank:id/card_details_cashback_conditions")
    protected MobileElement CASHBACK_CONDITIONS;

    public CardPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть на 'Условия программы'")
    public CashBackConditionsPage scrollAndTapOnDetailsCashBackConditions() {
        var text = elements.getTextFromElement(CASHBACK_CONDITIONS);
        screen.scrollablePageAndroidByText(text);
        buttons.searchAndClickButtonBy(CASHBACK_CONDITIONS);

        return new CashBackConditionsPage(getAndroidDriver());
    }
}
