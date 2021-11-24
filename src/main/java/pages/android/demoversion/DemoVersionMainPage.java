package pages.android.demoversion;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.accountsAndDeposits.AccountPage;
import pages.android.demoversion.more.MorePage;
import pages.android.demoversion.more.smsAndEmailNotices.PhoneAddition;
import pages.android.demoversion.paymensAndTransfers.PaymentsAndTransfersPage;

public class DemoVersionMainPage extends AndroidBasePage {
    private static final String NOT_AVAILABLE_MESSAGE = "Недоступно в демо-режиме";
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[contains(@text, 'Зарплатный счет')]/..")
    protected MobileElement SALARY_ACCOUNT;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_text")
    protected MobileElement NOT_AVAILABLE_IN_DEMO_VERSION_ALERT;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_button_ok")
    protected MobileElement OK_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_more")
    protected MobileElement MORE_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/done")
    protected MobileElement DONE_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_main_action_button")
    protected MobileElement PAYMENTS_BUTTON;

    public DemoVersionMainPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть 'Зарплатный Счет'")
    public AccountPage goToAccountPage() {
        buttons.searchAndClickButtonBy(SALARY_ACCOUNT);
        return new AccountPage(getAndroidDriver());
    }

    @Step("Всплывает предупреждение 'Недоступно в демо-режиме'")
    public boolean isExistAlertAboutNotAvailableInDemoVersionAndTapOK() {
        var isExistAlert = elements.getTextFromElement(NOT_AVAILABLE_IN_DEMO_VERSION_ALERT).equals(NOT_AVAILABLE_MESSAGE);
        tapOnOkButton();

        return isExistAlert;
    }

    @Step("Тапнуть кнопку 'Ок' в уведомлении")
    public void tapOnOkButton() {
        buttons.searchAndClickButtonBy(OK_BUTTON);
    }

    @Step("Тапнуть 'Еще'")
    public MorePage goToMorePage() {
        buttons.searchAndClickButtonBy(MORE_BUTTON);
        return new MorePage(getAndroidDriver());
    }

    @Step("Тапнуть на 'Готово'")
    public DemoVersionMainPage tapOnDone() {
        buttons.searchAndClickButtonBy(DONE_BUTTON);
        return this;
    }

    @Step("Тапнуть на 'Платежи'")
    public PaymentsAndTransfersPage tapOnPaymentsButton() {
        buttons.searchAndClickButtonBy(PAYMENTS_BUTTON);
        return new PaymentsAndTransfersPage(getAndroidDriver());
    }
}
