package pages.android.demoversion.more;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;
import pages.android.demoversion.more.smsAndEmailNotices.PhoneAndEmail;
import pages.android.mainscreen.CurrencyRatePage;

public class MorePage extends DemoVersionMainPage {

    @AndroidFindBy(id = "cb.ibank:id/logout")
    protected MobileElement LOGOUT_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Система быстрых платежей')]/..")
    protected MobileElement FAST_PAYMENT_SYSTEM_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Изменение пароля')]/..")
    protected MobileElement CHANGE_PASSWORD;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Персональные данные')]/..")
    protected MobileElement PERSONAL_DATA;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Вход по отпечатку пальца')]/../android.widget.Switch")
    protected MobileElement LOGON_BY_FINGERPRINT;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Push-уведомления')]/../android.widget.Switch")
    protected MobileElement PUSH_NOTIFICATIONS_TOGGLE;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Звонок в банк')]/..")
    protected MobileElement CALL_TO_BANK;
    @AndroidFindBy(id = "cb.ibank:id/common_bottom_sheet_dialog_title")
    protected MobileElement CHOOSE_CALL_VARIANT;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Курс валют')]/..")
    protected MobileElement CURRENCY_RATE;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'SMS/Email уведомления')]/..")
    protected MobileElement SMS_EMAIL_NOTIFICATIONS;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Адреса отделений')]/..")
    protected MobileElement DEPARTMENT_ADDRESSES;

    public MorePage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть на 'Выход'")
    public AndroidBasePage tapOnLogout() {
        buttons.searchAndClickButtonBy(LOGOUT_BUTTON);
        return new AndroidBasePage(getAndroidDriver());
    }

    @Step("Тапнуть на 'Система быстрых платежей'")
    public FastPaymentSystemPage tapOnFastPaymentSystem() {
        buttons.searchAndClickButtonBy(FAST_PAYMENT_SYSTEM_BUTTON);
        return new FastPaymentSystemPage(getAndroidDriver());
    }

    @Step("Тапнуть на 'Изменение пароля'")
    public MorePage tapOnChangePassword() {
        buttons.searchAndClickButtonBy(CHANGE_PASSWORD);
        return this;
    }

    @Step("Тапнуть на 'Персональные данные'")
    public PersonalDataPage tapOnPersonalData() {
        buttons.searchAndClickButtonBy(PERSONAL_DATA);
        return new PersonalDataPage(getAndroidDriver());
    }

    @Step("Тапнуть на toggle 'Вход по отпечатку пальца'")
    public MorePage tapOnLogonByFingerprintToggle() {
        buttons.searchAndClickButtonBy(LOGON_BY_FINGERPRINT);
        return this;
    }

    @Step("Тапнуть на toggle 'Push-уведомления'")
    public MorePage tapOnPushNotificationsToggle() {
        buttons.searchAndClickButtonBy(PUSH_NOTIFICATIONS_TOGGLE);
        return this;
    }

    @Step("Тапнуть на 'Звонок в банк'")
    public MorePage tapOnCallToBank() {
        buttons.searchAndClickButtonBy(CALL_TO_BANK);
        return this;
    }

    @Step("Отображается всплывающая шторка с выбором звонка")
    public boolean isDisplayedCurtainWithCallSelect() {
        return elements.isElementExist(CHOOSE_CALL_VARIANT);
    }

    @Step("Тапнуть на 'Курсы валют'")
    public CurrencyRatePage tapOnCurrencyRates() {
        buttons.searchAndClickButtonBy(CURRENCY_RATE);
        return new CurrencyRatePage(getAndroidDriver());
    }

    @Step("Тапнуть на 'SMS/Email уведомления'")
    public PhoneAndEmail tapOnSmsAndEmailNotifications() {
        buttons.searchAndClickButtonBy(SMS_EMAIL_NOTIFICATIONS);
        return new PhoneAndEmail(getAndroidDriver());
    }

    @Step("Тапнуть на 'Адреса отделений'")
    public DepartmentAddressesPage tapOnDepartmentAddresses() {
        buttons.searchAndClickButtonBy(DEPARTMENT_ADDRESSES);
        return new DepartmentAddressesPage(getAndroidDriver());
    }
}
