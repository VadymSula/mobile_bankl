package core.base;

import elements.Buttons;
import elements.Elements;
import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.android.authorization.signin.SignInByLogin;
import pages.android.demoversion.accountsAndDeposits.AccountPage;
import pages.android.mainscreen.BecomeClientPage;
import pages.android.mainscreen.CurrencyRatePage;
import pages.android.mainscreen.DepartmentAddressesPage;
import utils.mobile.Waiters;

public class AndroidBasePage {
    private AndroidDriver<MobileElement> androidDriver;
    protected Buttons buttons;
    protected Screen screen;
    protected Elements elements;
    protected Waiters waiters;

    public AndroidBasePage(AndroidDriver<MobileElement> androidDriver) {
        this.androidDriver = androidDriver;
        waiters = new Waiters(androidDriver);
        buttons = new Buttons(androidDriver, waiters);
        screen = new Screen(androidDriver, waiters);
        elements = new Elements(androidDriver, waiters);

        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
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
    @AndroidFindBy(id = "cb.ibank:id/view_controller_welcome_title")
    protected MobileElement WELCOME_TITLE;

    @Step("Тапнуть на кнопку 'Курс валют'")
    public CurrencyRatePage goToCurrencyRatesPage() {
        buttons.waitInSecondsAndClickButtonBy(CURRENCY_RATES_BUTTON, 3);
        return new CurrencyRatePage(getAndroidDriver());
    }

    @Step("Тапнуть на кнопку 'Адреса'")
    public DepartmentAddressesPage goToDepartmentAddressesPage() {
        buttons.searchAndClickButtonBy(DEPARTMENT_ADDRESSES_BUTTON);
        return new DepartmentAddressesPage(getAndroidDriver());
    }

    @Step("Тапнуть на блок Стать клиентом")
    public BecomeClientPage goToBecomeClientPage() {
        buttons.searchAndClickButtonBy(BECOME_CLIENT_BUTTON);
        return new BecomeClientPage(getAndroidDriver());
    }

    @Step("Тап на кнопку 'Войти'")
    public SignInByLogin goToSignInPage() {
        buttons.searchAndClickButtonBy(LOGIN_BUTTON);
        return new SignInByLogin(getAndroidDriver());
    }

    @Step("Тапнуть на кнопку 'Демо-версия'")
    public AccountPage goToDemoVersion() {
        buttons.searchAndClickButtonBy(DEMO_VERSION_BUTTON);
        return new AccountPage(getAndroidDriver());
    }

    public boolean isDisplayStartPage() {
        return elements.isElementExist(WELCOME_TITLE);
    }

    public AndroidDriver<MobileElement> getAndroidDriver() {
        return androidDriver;
    }
}
