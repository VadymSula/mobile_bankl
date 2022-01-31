package pages.android.demoversion.card;

import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;
import pages.android.demoversion.card.limits.DemoLimitsPage;

public class DemoCardPage extends DemoVersionMainPage {
    private static final String LIMITS_TEXT = "Лимиты";

    @AndroidFindBy(id = "cb.ibank:id/card_details_cashback_conditions")
    protected MobileElement CASHBACK_CONDITIONS;
    @AndroidFindBy(id = "cb.ibank:id/card_details_action_set_up_pin")
    protected MobileElement SET_PIN_CODE_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Действия']")
    protected MobileElement ACTIONS_BLOCK;
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

    @Step("Проскроллить к блоку 'Действия'")
    public DemoCardPage scrollToActionsBlock() {
        screen.swipeScreenWithPressTime(Screen.Direction.UP, 1000, null);
        return this;
    }

    @Step("Тапнуть на опцию 'Установить ПИН-код'")
    public DemoCardPage tapOnSetPinCodeButton() {
        buttons.searchAndClickButtonBy(SET_PIN_CODE_BUTTON);
        return this;
    }

    @Step("Блок 'Действия' отображается в шторке с информацией по карте.")
    public boolean isDisplayActionsBlock() {
        return elements.isElementExist(ACTIONS_BLOCK);
    }

    @Step("Тапнуть на 'Лимиты'")
    public DemoLimitsPage tapOnLimitsButton() {
        screen.scrollablePageAndroidByText(LIMITS_TEXT);
        buttons.searchAndClickButtonBy(LIMITS_BUTTON);
        return new DemoLimitsPage(getAndroidDriver());
    }

    @Step("Проскроллить к блоку 'Действия' и тапнуть на 'Изменить ПИН-код'")
    public DemoCardPage scrollAndTapOnEditPinCode() {
        screen.swipeScreenWithPressTime(Screen.Direction.UP, 1000, null);
        buttons.searchAndClickButtonBy(EDIT_PIN_CODE_BUTTON);
        return this;
    }
}
