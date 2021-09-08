package pages.android.demoversion;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import core.base.AndroidBasePage;
import pages.android.demoversion.accountsAndDeposits.AccountRefillPage;

public class DemoVersionMainPage extends AndroidBasePage {
    private static final String NOT_AVAILABLE_MESSAGE = "Недоступно в демо-режиме";
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[contains(@text, 'Зарплатный счет')]/..")
    protected MobileElement SALARY_ACCOUNT;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_text")
    protected MobileElement NOT_AVAILABLE_IN_DEMO_VERSION_ALERT;

    public DemoVersionMainPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @Step("Тапнуть 'Зарплатный Счет'")
    public AccountRefillPage goToAccountRefill() {
        buttons.searchAndClickButtonBy(SALARY_ACCOUNT);
        return new AccountRefillPage(getAppiumDriver());
    }

    @Step("Всплывает предупреждение 'Недоступно в демо-режиме'")
    public boolean isExistAlertAboutNotAvailableInDemoVersion() {
        return elements.getTextFromElement(NOT_AVAILABLE_IN_DEMO_VERSION_ALERT).equals(NOT_AVAILABLE_MESSAGE);
    }


}
