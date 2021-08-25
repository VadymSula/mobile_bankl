package pages.android;

import elements.Buttons;
import elements.Elements;
import elements.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AndroidBasePage {
    private AndroidDriver<MobileElement> androidDriver;
    protected Buttons buttons;
    protected Screen screen;
    protected Elements elements;

    public AndroidBasePage(AndroidDriver<MobileElement> androidDriver) {
        buttons = new Buttons();
        screen = new Screen();
        elements = new Elements();
        this.androidDriver = androidDriver;
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

}
