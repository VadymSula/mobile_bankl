package pages.android.authorization.singin;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.android.AndroidBasePage;

public class SignInByLogin extends AndroidBasePage {

    @AndroidFindBy(accessibility = "По Логину")
    protected MobileElement BY_LOGIN_SECTION;
    @AndroidFindBy(accessibility = "По карте")
    protected MobileElement BY_CARD_SECTION;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_login_edit_text_layout")
    protected MobileElement LOGIN_TEXTFIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_password_edit_text_layout")
    protected MobileElement PASSWORD_TEXTFIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_button_forgot_login_or_password")
    protected MobileElement FORGOT_LOGIN_OR_PASSWORD_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_button_login")
    protected MobileElement SIGN_IN_BUTTON;

    public SignInByLogin(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }
}
