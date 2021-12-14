package pages.android.authorization;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.PersonalCabinetMainPage;
import utils.integration.fimi.SOAPClientSAAJ;

public class ConfirmLoginPage extends AndroidBasePage {

    private static final String SMS_MESSAGE = "Мы отправили вам сообщение на";
    private static final String TIMER_TEXT = "Код действует:";
    private static final String TIME_OUT_TEXT = "Время действия кода истекло";
    @AndroidFindBy(id = "cb.ibank:id/view_controller_confirm_sms_title")
    protected MobileElement CONFIRM_SMS_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_confirm_sms_edit_text")
    protected MobileElement CONFIRM_SMS_FIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_confirm_sms_code_valid_timer")
    protected MobileElement SMS_CODE_VALID_TIMER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_confirm_sms_button_confirm")
    protected MobileElement CONFIRM_SMS_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_button_cancel")
    protected MobileElement CANCEL_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_button_ok")
    protected MobileElement OK_BUTTON;

    public ConfirmLoginPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Ввести код из смс")
    public ConfirmLoginPage inputCheckingCodeInFieldByCode() {
        elements.searchFieldAndSendKey(
                CONFIRM_SMS_FIELD,
                SOAPClientSAAJ.getDynamicCodeByHisNumber(getNumberOfCheckingCode())
        );

        return this;
    }

    @Step("Тапнуть на кнопку \"Готово\"")
    public PersonalCabinetMainPage tapOnReadyButton() {
        buttons.searchAndClickButtonBy(CONFIRM_SMS_BUTTON);
        return new PersonalCabinetMainPage(getAndroidDriver());
    }

    @Step("Отображается экран подтверждения: ")
    public boolean isDisplaySignInScreenAndSections() {
        return isDisplayMessageAboutConfirmSms() &&
                isDisplayCheckingCodeField() &&
                isDisplayKeyboardOnScreen() &&
                isDisplayTimerAndContainsPhrase() &&
                isDisplayConfirmSmsButtonAndDisabled();
    }

    @Step("Отображается заголовок \"Мы отправили вам сообщение на ...\"")
    private boolean isDisplayMessageAboutConfirmSms() {
        var isExistMessage = elements.isElementExist(CONFIRM_SMS_TITLE);
        var isContainsMessagePhrase = elements.getTextFromElement(CONFIRM_SMS_TITLE).contains(SMS_MESSAGE);

        return isExistMessage && isContainsMessagePhrase;
    }

    @Step("Отображается поле \"Проверочный код #1\" в фокусе")
    private boolean isDisplayCheckingCodeField() {
        return elements.isElementExist(CONFIRM_SMS_FIELD);
    }

    @Step("Отображается клавиатура с цифрами")
    private boolean isDisplayKeyboardOnScreen() {
        return getAndroidDriver().isKeyboardShown();
    }

    @Step("Отображается таймер \"Код действует:\"")
    private boolean isDisplayTimerAndContainsPhrase() {
        var isExistField = elements.isElementExist(SMS_CODE_VALID_TIMER);
        var isContainsPhrase = elements.getTextFromElement(SMS_CODE_VALID_TIMER).contains(TIMER_TEXT);

        return isExistField && isContainsPhrase;
    }

    @Step("Отображается кнопка \"Готово\" (неактивна пока код не введен)")
    private boolean isDisplayConfirmSmsButtonAndDisabled() {
        var isExistButton = elements.isElementExist(CONFIRM_SMS_BUTTON);
        var isDisableButton = !elements.isEnableElement(CONFIRM_SMS_BUTTON);
        
        return isExistButton && isDisableButton;
    }

    private String getNumberOfCheckingCode() {
        return elements.getTextFromElement(CONFIRM_SMS_FIELD).replaceAll("[^0-9]", "");
    }

    public boolean isExistAndContainsTextTimeOutMessage() {
        return elements.isElementExist(ALERT_TEXT) && elements.getTextFromElement(ALERT_TEXT).contains(TIME_OUT_TEXT);
    }
}
