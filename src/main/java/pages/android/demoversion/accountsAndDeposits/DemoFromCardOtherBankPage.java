package pages.android.demoversion.accountsAndDeposits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class DemoFromCardOtherBankPage extends DemoVersionMainPage {
    @AndroidFindBy(id = "cb.ibank:id/view_cvv_field_title_text")
    protected MobileElement CVV_INPUT_FIELD;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Сумма')]")
    protected MobileElement SUM_INPUT_FIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_cards_other_bank_refill_button_next")
    protected MobileElement NEXT_BUTTON;

    public DemoFromCardOtherBankPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Заполнить 'СVV'")
    public DemoFromCardOtherBankPage toFillCvvOnField(String cvvCode) {
        elements.searchFieldAndSendKey(CVV_INPUT_FIELD, cvvCode);
        return this;
    }

    @Step("Заполнить 'Сумма'")
    public DemoFromCardOtherBankPage toFillSumOnField(String sum) {
        elements.searchFieldAndSendKey(SUM_INPUT_FIELD, sum);
        return this;
    }

    @Step("Тапнуть 'Далее'")
    public DemoFromCardOtherBankPage tapOnTheNextButton() {
        buttons.searchAndClickButtonBy(NEXT_BUTTON);
        return this;
    }
}
