package pages.android.demoversion.card;

import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;
import pages.android.demoversion.card.cashback.DemoCashBackConditionsPage;
import pages.android.demoversion.card.limits.DemoLimitsPage;

public class DemoCardPage extends DemoVersionMainPage {
    private static final String SET_PIN_CODE_TEXT = "Установить ПИН-код";
    private static final String LIMITS_TEXT = "Лимиты";
    private static final String EDIT_PIN_CODE_TEXT = "Изменить ПИН-код";

    @AndroidFindBy(id = "cb.ibank:id/card_details_cashback_conditions")
    protected MobileElement CASHBACK_CONDITIONS;
    @AndroidFindBy(id = "cb.ibank:id/card_details_action_set_up_pin")
    protected MobileElement SET_PIN_CODE_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/card_details_action_limits")
    protected MobileElement LIMITS_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/card_details_action_edit_pin_code")
    protected MobileElement EDIT_PIN_CODE_BUTTON;

    public DemoCardPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть на 'Условия программы'")
    public DemoCashBackConditionsPage scrollAndTapOnDetailsCashBackConditions() {
        var text = elements.getTextFromElement(CASHBACK_CONDITIONS);
        screen.scrollablePageAndroidByText(text);
        buttons.searchAndClickButtonBy(CASHBACK_CONDITIONS);

        return new DemoCashBackConditionsPage(getAndroidDriver());
    }

    @Step("Тапнуть на 'Установить ПИН-код'")
    public DemoCardPage scrollAndTapOnSetPinCodeButton() {
        screen.scrollablePageAndroidByText(SET_PIN_CODE_TEXT);
        buttons.searchAndClickButtonBy(SET_PIN_CODE_BUTTON);

        return this;
    }

    @Step("Тапнуть на 'Лимиты'")
    public DemoLimitsPage tapOnLimitsButton() {
        screen.scrollablePageAndroidByText(LIMITS_TEXT);
        buttons.searchAndClickButtonBy(LIMITS_BUTTON);

        return new DemoLimitsPage(getAndroidDriver());
    }

    @Step("Тапнуть на 'Изменить ПИН-код'")
    public DemoCardPage scrollAndTapOnEditPinCode() {
        screen.swipeScreenWithPressTime(Screen.Direction.UP, 1000, null);
        buttons.searchAndClickButtonBy(EDIT_PIN_CODE_BUTTON);

        return this;
    }
}
