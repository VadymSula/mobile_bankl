package pages.android.demoversion.accountsAndDeposits;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class AccountRefillPage extends DemoVersionMainPage {
    private static final String SALARY_ACCOUNT_NAME = "Зарплатный счет";

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.TextView[contains(@text, 'Пополнить')]/..")
    protected MobileElement ACCOUNT_REFILL_BUTTON;
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

    public AccountRefillPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @Step("Тапнуть 'Пополнить'")
    public AccountRefillPage tapOnRefillButton() {
        buttons.searchAndClickButtonBy(ACCOUNT_REFILL_BUTTON);
        return this;
    }

    @Step("Тапнуть 'Со своего счета'")
    public AccountRefillPage tapOnFromMyAccountButton() {
        buttons.searchAndClickButtonBy(FROM_MY_ACCOUNT_BUTTON);
        return this;
    }

    @Step("Тапнуть 'С карты другого банка'")
    public ChooseCardPage tapOnFromCardOfOtherBankButton() {
        buttons.searchAndClickButtonBy(FROM_CARD_OTHER_BANK);
        return new ChooseCardPage(getAppiumDriver());
    }

    @Step("Тапнуть 'Запросить платеж'")
    public AccountRefillPage tapOnRequestPaymentButton() {
        buttons.searchAndClickButtonBy(REQUEST_PAYMENT);
        return this;
    }

    @Step("В поле 'Счет пополнения' указан выбранный ранее счет")
    public boolean isExistSelectedAccount() {
        return elements.getTextFromElement(PAYMENT_ACCOUNT_NAME).equals(SALARY_ACCOUNT_NAME);
    }

    @Step("Тапнуть на поле 'Счет списания'")
    public AccountRefillPage tapOnTransferFromAccountSender() {
        buttons.searchAndClickButtonBy(TRANSFER_FROM_ACCOUNT_SENDER);
        return this;
    }

    @Step("Выбрать чек-бокс счета 'Накопительный счет'")
    public AccountRefillPage chooseDepositAccountCheckbox() {
        buttons.searchAndClickButtonBy(DEPOSIT_ACCOUNT_VARIANT_TRANSFER);
        return this;
    }

    @Step("В поле 'Сумма' указать сумму")
    public AccountRefillPage inputSumForTransfer(String sumOfTransfer) {
        buttons.searchAndClickButtonBy(SUM_OF_TRANSFER_EDITTEXT);
        elements.sendKeyFromAction(sumOfTransfer);
        return this;
    }

    @Step("Тапнуть 'Перевести'")
    public AccountRefillPage tapOnTransferButton() {
        buttons.searchAndClickButtonBy(TRANSFER_BUTTON);
        return this;
    }
}
