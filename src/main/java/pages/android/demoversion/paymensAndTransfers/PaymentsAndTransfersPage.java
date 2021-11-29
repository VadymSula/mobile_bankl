package pages.android.demoversion.paymensAndTransfers;

import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;
import pages.android.demoversion.DemoVersionMainPage;
import pages.android.demoversion.paymensAndTransfers.payments.MobileConnectionPage;
import pages.android.demoversion.paymensAndTransfers.transfers.*;

public class PaymentsAndTransfersPage extends DemoVersionMainPage {
    private final Point paymentsPoint = screen.setPointForSwipe(1.25F, 2F);

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'По номеру телефона')]/..")
    protected MobileElement BY_PHONE_NUMBER_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Между счетами')]/..")
    protected MobileElement BETWEEN_ACCOUNTS;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'По номеру карты')]/..")
    protected MobileElement BY_CARD_NUMBER;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'По реквизитам счёта')]/..")
    protected MobileElement BY_REQUISITES;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'СБП')]/..")
    protected MobileElement SYSTEM_OF_FAST_PAYMENTS;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Оплата по QR-коду')]/..")
    protected MobileElement BY_QR_CODE;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Мобильная связь')]/..")
    protected MobileElement MOBILE_CONNECTION;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Оплата услуг ЖКХ')]/..")
    protected MobileElement PAYMENT_OF_UTILITY_SERVICES;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Домашний телефон')]/..")
    protected MobileElement HOME_PHONE;

    public PaymentsAndTransfersPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть на 'По номеру телефона' в разделе 'Переводы'")
    public ByPhoneNumberPage tapOnByPhoneNumberButton() {
        buttons.searchAndClickButtonBy(BY_PHONE_NUMBER_BUTTON);
        return new ByPhoneNumberPage(getAndroidDriver());
    }

    @Step("Тапнуть на кнопку 'Между счетами'")
    public BetweenAccountsPage tapOnBetweenAccountsButton() {
        buttons.searchAndClickButtonBy(BETWEEN_ACCOUNTS);
        return new BetweenAccountsPage(getAndroidDriver());
    }

    @Step("Тапнуть кнопку 'По номеру карты'")
    public ByCardNumberPage tapOnByCardNumberButton() {
        buttons.searchAndClickButtonBy(BY_CARD_NUMBER);
        return new ByCardNumberPage(getAndroidDriver());
    }

    @Step("Тапнуть кнопку 'По реквизитам'")
    public ByRequisitesPage tapOnByRequisitesButton() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 1000, null);
        buttons.searchAndClickButtonBy(BY_REQUISITES);
        return new ByRequisitesPage(getAndroidDriver());
    }

    @Step("Тапнуть кнопку 'СБП'")
    public PaymentsAndTransfersPage tapOnSBPButton() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 1000, null);
        buttons.searchAndClickButtonBy(SYSTEM_OF_FAST_PAYMENTS);
        return this;
    }

    @Step("Тапнуть кнопку 'По номеру телефона'")
    public SystemOfFastPaymentsPage tapOnByPhoneNumberButtonThroughSBP() {
        buttons.searchAndClickButtonBy(BY_PHONE_NUMBER_BUTTON);
        return new SystemOfFastPaymentsPage(getAndroidDriver());
    }

    @Step("Тапнуть на кнопку 'Оплата по QR-коду'")
    public PaymentsAndTransfersPage tapOnPaymentByQRCodeButton() {
        buttons.searchAndClickButtonBy(BY_QR_CODE);
        return this;
    }

    @Step("Тапнуть кнопку 'Мобильная связь'")
    public MobileConnectionPage tapOnMobileConnectionButton() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 800, paymentsPoint);
        buttons.searchAndClickButtonBy(MOBILE_CONNECTION);
        return new MobileConnectionPage(getAndroidDriver());
    }

    @Step("Тапнуть кнопку 'Оплата услуг ЖКХ'")
    public PaymentsAndTransfersPage tapOnPaymentOfUtilityServices() {
        screen.swipeScreenWithPressTime(Screen.Direction.LEFT, 200, paymentsPoint);
        buttons.searchAndClickButtonBy(PAYMENT_OF_UTILITY_SERVICES);
        return this;
    }

    @Step("Тапнуть на кнопку 'Домашний телефон'")
    public PaymentsAndTransfersPage tapOnHomePhoneButton() {
        buttons.searchAndClickButtonBy(HOME_PHONE);
        return this;
    }
}