package pages.android.demoversion.paymensAndTransfers.payments;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class MobileConnectionPage extends DemoVersionMainPage {

    @AndroidFindBy(id = "cb.ibank:id/view_controller_contacts_search_edit_text")
    protected MobileElement PHONE_NUMBER_FIELD;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Новый номер')]/..")
    protected MobileElement NEW_PHONE_NUMBER;
    @AndroidFindBy(className = "android.widget.EditText")
    protected MobileElement SUM_FIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_top_up_mobile_button_next")
    protected MobileElement MOBILE_CONNECTION_TRANSFER_BUTTON;

    public MobileConnectionPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Ввести в поле: {phoneNumber}")
    public MobileConnectionPage inputPhoneNumberInField(String phoneNumber) {
        elements.searchFieldAndSendKey(PHONE_NUMBER_FIELD, phoneNumber);
        return this;
    }

    @Step("Тапнуть по кнопке/полю 'Новый номер'")
    public MobileConnectionPage tapOnNewPhoneNumberButton() {
        buttons.searchAndClickButtonBy(NEW_PHONE_NUMBER);
        return this;
    }

    @Step("Заполнить поле 'Сумма': {sum}")
    public MobileConnectionPage fillOnSumField(String sum) {
        elements.searchFieldAndSendKey(SUM_FIELD, sum);
        return this;
    }

    @Step("Тапнуть по кнопке 'Перевести'")
    public MobileConnectionPage tapOnTransferButton() {
        buttons.searchAndClickButtonBy(MOBILE_CONNECTION_TRANSFER_BUTTON);
        return this;
    }
}
