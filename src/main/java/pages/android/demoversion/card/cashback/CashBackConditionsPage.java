package pages.android.demoversion.card.cashback;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.card.CardPage;

public class CashBackConditionsPage extends CardPage {
    private static final String LABEL_STATUS = "НАЖМИТЕ, ЧТОБЫ ОЗНАКОМИТЬСЯ";

    @AndroidFindBy(id = "cb.ibank:id/item_document_view")
    protected MobileElement DETAIL_CONDITIONS;

    public CashBackConditionsPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть на 'Полные условия'")
    public CashBackConditionsPage scrollAndTapOnDetailConditions() {
        screen.scrollablePageAndroidByText(LABEL_STATUS);
        buttons.searchAndClickButtonBy(DETAIL_CONDITIONS);
        return this;
    }
}