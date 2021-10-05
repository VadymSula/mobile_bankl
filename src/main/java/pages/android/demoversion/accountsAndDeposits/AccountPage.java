package pages.android.demoversion.accountsAndDeposits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;
import pages.android.demoversion.card.CardPage;

public class AccountPage extends DemoVersionMainPage {
    private static final String SALARY_ACCOUNT_NAME = "Зарплатный счет";
    private static final String CERTIFICATE_AVAILABLE_RESIDUE_TEXT = "Справка о доступном остатке";

    @AndroidFindBy(accessibility = "Переименовать")
    protected MobileElement EDIT_NAME_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.TextView[contains(@text, 'Пополнить')]/..")
    protected MobileElement ACCOUNT_REFILL_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.TextView[contains(@text, 'Реквизиты')]/..")
    protected MobileElement REQUISITES_BUTTON;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.TextView[contains(@text, '3457')]/..")
    protected MobileElement CARD_WITHOUT_PIN_CODE;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Со своего счёта')]")
    protected MobileElement FROM_MY_ACCOUNT_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'С карты другого банка')]")
    protected MobileElement FROM_CARD_OTHER_BANK;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Запросить платеж')]")
    protected MobileElement REQUEST_PAYMENT;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_recipient")
    protected MobileElement TRANSFER_TO_ACCOUNT_RECIPIENT;
    @AndroidFindBy(id = "cb.ibank:id/view_payment_account_name")
    protected MobileElement PAYMENT_ACCOUNT_NAME;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_empty_sender")
    protected MobileElement TRANSFER_FROM_ACCOUNT_SENDER;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Накопительный счет')]/..")
    protected MobileElement DEPOSIT_ACCOUNT_VARIANT_TRANSFER;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.EditText")
    protected MobileElement SUM_OF_TRANSFER_EDITTEXT;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_transfer_to_account_button_next")
    protected MobileElement TRANSFER_BUTTON;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    protected MobileElement CARD_WITH_PIN_CODE;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '" + CERTIFICATE_AVAILABLE_RESIDUE_TEXT + "')]/..")
    protected MobileElement CERTIFICATE_AVAILABLE_RESIDUE;
//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Выписка по счёту')]/..")
//    protected MobileElement ACCOUNT_STATEMENT;

    public AccountPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть 'Переименовать'")
    public AccountPage tapOnEditNameButton() {
        buttons.searchAndClickButtonBy(EDIT_NAME_BUTTON);
        return this;
    }

    @Step("Тапнуть 'Пополнить'")
    public AccountPage tapOnRefillButton() {
        buttons.searchAndClickButtonBy(ACCOUNT_REFILL_BUTTON);
        return this;
    }

    @Step("Тапнуть 'Реквизиты'")
    public RequisitesPage tapOnRequisites() {
        buttons.searchAndClickButtonBy(REQUISITES_BUTTON);
        return new RequisitesPage(getAndroidDriver());
    }

    @Step("Тапнуть на 'Карту' с номером 1223 4500 0000 3457")
    public CardPage tapOnCardWithoutPinCode() {
        buttons.searchAndClickButtonBy(CARD_WITHOUT_PIN_CODE);
        return new CardPage(getAndroidDriver());
    }

    @Step("Тапнуть 'Со своего счета'")
    public AccountPage tapOnFromMyAccountButton() {
        buttons.searchAndClickButtonBy(FROM_MY_ACCOUNT_BUTTON);
        return this;
    }

    @Step("Тапнуть 'С карты другого банка'")
    public ChooseCardPage tapOnFromCardOfOtherBankButton() {
        buttons.searchAndClickButtonBy(FROM_CARD_OTHER_BANK);
        return new ChooseCardPage(getAndroidDriver());
    }

    @Step("Тапнуть 'Запросить платеж'")
    public AccountPage tapOnRequestPaymentButton() {
        buttons.searchAndClickButtonBy(REQUEST_PAYMENT);
        return this;
    }

    @Step("В поле 'Счет пополнения' указан выбранный ранее счет")
    public boolean isExistSelectedAccount() {
        return elements.getTextFromElement(PAYMENT_ACCOUNT_NAME).equals(SALARY_ACCOUNT_NAME);
    }

    @Step("Тапнуть на поле 'Счет списания'")
    public AccountPage tapOnTransferFromAccountSender() {
        buttons.searchAndClickButtonBy(TRANSFER_FROM_ACCOUNT_SENDER);
        return this;
    }

    @Step("Выбрать чек-бокс счета 'Накопительный счет'")
    public AccountPage chooseDepositAccountCheckbox() {
        buttons.searchAndClickButtonBy(DEPOSIT_ACCOUNT_VARIANT_TRANSFER);
        return this;
    }

    @Step("В поле 'Сумма' указать сумму")
    public AccountPage inputSumForTransfer(String sumOfTransfer) {
        buttons.searchAndClickButtonBy(SUM_OF_TRANSFER_EDITTEXT);
        elements.sendKeyFromAction(sumOfTransfer);
        return this;
    }

    @Step("Тапнуть 'Перевести'")
    public AccountPage tapOnTransferButton() {
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON);
        return this;
    }

    @Step("Тапнуть на 'Карту'")
    public CardPage tapOnCardWithPinCode() {
        buttons.searchAndClickButtonBy(CARD_WITH_PIN_CODE);
        return new CardPage(getAndroidDriver());
    }

    @Step("Тапнуть '" + CERTIFICATE_AVAILABLE_RESIDUE_TEXT + "'")
    public CertificateAvailableResiduePage tapOnCertificateAvailableResidue() {
        screen.scrollablePageAndroidByText(CERTIFICATE_AVAILABLE_RESIDUE_TEXT);
        buttons.searchAndClickButtonBy(CERTIFICATE_AVAILABLE_RESIDUE);
        return new CertificateAvailableResiduePage(getAndroidDriver());
    }
}
