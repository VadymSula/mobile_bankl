package pages.android.demoversion.accountsAndDeposits;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class CertificateAvailableResiduePage extends DemoVersionMainPage {
    @AndroidFindBy(id = "cb.ibank:id/include_statements_and_references_email_text")
    protected MobileElement EMAIL_FIELD;
    @AndroidFindBy(id = "cb.ibank:id/include_statements_and_references_account")
    protected MobileElement ACCOUNT_SELECTOR;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_funds_availability_send_button")
    protected MobileElement SEND_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.RadioGroup/android.widget.LinearLayout[1]")
    protected MobileElement FIRST_CHECKBOX_ACCOUNT;

    public CertificateAvailableResiduePage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Указать 'Email'")
    public CertificateAvailableResiduePage fillTheEmailField(String email) {
        elements.searchFieldAndSendKey(EMAIL_FIELD, email);
        return this;
    }

    @Step("Тапнуть на 'Счет'")
    public CertificateAvailableResiduePage tapOnAccountSelector() {
        buttons.searchAndClickButtonBy(ACCOUNT_SELECTOR);
        return this;
    }

    @Step("Тапнуть на один из чек-боксов доступных счетов")
    public CertificateAvailableResiduePage tapOnFirstCheckboxFromAccounts() {
        buttons.searchAndClickButtonBy(FIRST_CHECKBOX_ACCOUNT);
        return this;
    }

    @Step("Тапнуть на 'Отправить'")
    public CertificateAvailableResiduePage tapOnSendButton() {
        buttons.searchAndClickButtonBy(SEND_BUTTON);
        return this;
    }
}
