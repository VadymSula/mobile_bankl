package core.base;

import elements.Buttons;
import elements.Elements;
import elements.Screen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.android.authorization.singin.SignInByLogin;
import pages.android.demoversion.accountsAndDeposits.AccountRefillPage;
import pages.android.mainscreen.BecomeClientPage;
import pages.android.mainscreen.CurrencyRatePage;
import pages.android.mainscreen.DepartmentAddressesPage;
import utils.Waiters;

public class AndroidBasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    protected Buttons buttons;
    protected Screen screen;
    protected Elements elements;
    protected Waiters waiters;

    public AndroidBasePage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        waiters = new Waiters(appiumDriver);
        buttons = new Buttons(appiumDriver, waiters);
        screen = new Screen(appiumDriver, waiters);
        elements = new Elements(appiumDriver, waiters);

        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_button_login")
    protected MobileElement LOGIN_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_button_become_client")
    protected MobileElement BECOME_CLIENT_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_test_settings")
    protected MobileElement SETTINGS_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/include_department_addresses")
    protected MobileElement DEPARTMENT_ADDRESSES_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/include_currency_rates")
    protected MobileElement CURRENCY_RATES_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_demo_version")
    protected MobileElement DEMO_VERSION_BUTTON;

    @Step("Тапнуть на кнопку 'Курс валют'")
    public CurrencyRatePage goToCurrencyRatesPage() {
        buttons.waitInSecondsAndClickButtonBy(CURRENCY_RATES_BUTTON, 3);
        return new CurrencyRatePage(getAppiumDriver());
    }

    @Step("Тапнуть на кнопку 'Адреса'")
    public DepartmentAddressesPage goToDepartmentAddressesPage() {
        buttons.searchAndClickButtonBy(DEPARTMENT_ADDRESSES_BUTTON);
        return new DepartmentAddressesPage(getAppiumDriver());
    }

    @Step("Тапнуть на блок Стать клиентом")
    public BecomeClientPage goToBecomeClientPage() {
        buttons.searchAndClickButtonBy(BECOME_CLIENT_BUTTON);
        return new BecomeClientPage(getAppiumDriver());
    }

    @Step("Тап на кнопку 'Войти'")
    public SignInByLogin goToSignInPage() {
        buttons.searchAndClickButtonBy(LOGIN_BUTTON);
        return new SignInByLogin(getAppiumDriver());
    }

    @Step("Тапнуть на кнопку 'Демо-версия'")
    public AccountRefillPage goToDemoVersion() {
        buttons.searchAndClickButtonBy(DEMO_VERSION_BUTTON);
        return new AccountRefillPage(getAppiumDriver());
    }

    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }
}
