package pages.android.authorization.singin;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.android.AndroidBasePage;

import java.io.IOException;

public class SignInByLogin extends AndroidBasePage {
    private static final String USER_IS_NOT_EXIST_ALERT_TEXT = "Алерт 'Мы не нашли пользователя с такими данными. Убедитесь, что все введено корректно'";
    private static final String PART_OF_ALERT_MESSAGE_ABOUT_NON_EXIST_USER = "Мы не нашли";
    @AndroidFindBy(accessibility = "По Логину")
    protected MobileElement BY_LOGIN_SECTION;
    @AndroidFindBy(accessibility = "По карте")
    protected MobileElement BY_CARD_SECTION;
    @AndroidFindBy(xpath = "//androidx.viewpager.widget.ViewPager/android.widget.ScrollView/android.view.ViewGroup")
    protected MobileElement FORM_CONTAINER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_login_title")
    protected MobileElement LOGIN_TITLE;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_login_edit_text_layout")
    protected MobileElement LOGIN_TEXTFIELD;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_password_edit_text_layout")
    protected MobileElement PASSWORD_TEXTFIELD;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    protected MobileElement LOGIN_EDITTEXT;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    protected MobileElement PASSWORD_EDITTEXT;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'логин')]")
    protected MobileElement LOGIN_PLACEHOLDER;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Пароль')]")
    protected MobileElement PASSWORD_PLACEHOLDER;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_button_forgot_login_or_password")
    protected MobileElement FORGOT_LOGIN_OR_PASSWORD_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_login_button_login")
    protected MobileElement SIGN_IN_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_progress")
    protected MobileElement PROGRESS_SPINNER_ON_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_text")
    protected MobileElement ALERT_TEXT;
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_text")
    protected MobileElement PROGRESS_BUTTON;

    public SignInByLogin(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @Step("Экран с формой для входа отображается")
    public boolean isVisibleScreenWithFormForLogin() {
        return elements.isElementExist(FORM_CONTAINER);
    }

    @Step("Тап на вкладку 'Логин'")
    public SignInByLogin tapOnLoginSection() {
        buttons.searchAndClickButtonBy(BY_LOGIN_SECTION);
        return this;
    }

    @Step("Экран 'Вход в мобильный банк по логину' отображается")
    public boolean isVisibleLoginTitle() {
        return elements.isElementExist(LOGIN_TITLE);
    }

    @Step("В полях формы присутствует плейсхолдер")
    public boolean isExistPlaceholdersInForm() {
        return elements.isElementExist(LOGIN_PLACEHOLDER) && elements.isElementExist(PASSWORD_PLACEHOLDER);
    }

    @Step("Заполнить поля 'Идентификатор/логин' и 'Пароль' невалидными данными")
    public SignInByLogin fullInFieldsForLoginNotValidData(String idOrLogin, String password) {
        buttons.searchAndClickButtonBy(LOGIN_TEXTFIELD);
        elements.sendKeyFromAction(idOrLogin);
        buttons.searchAndClickButtonBy(PASSWORD_TEXTFIELD);
        elements.sendKeyFromAction(password);
        return this;
    }

    @Step("Тап на кнопку 'Войти'")
    public SignInByLogin tapOnSignInButton() {
        buttons.searchAndClickButtonBy(SIGN_IN_BUTTON);
        return this;
    }

    @Step(USER_IS_NOT_EXIST_ALERT_TEXT)
    public boolean isExistFailAlertAfterSignIn() {
        var textFromAlert = elements.getTextFromElement(ALERT_TEXT);

        return textFromAlert.contains(PART_OF_ALERT_MESSAGE_ABOUT_NON_EXIST_USER);
    }

    @Step("Кнопка 'Ок' отображается на экране")
    public boolean isExistOKButtonOnScreen() {
        return elements.isElementExist(PROGRESS_BUTTON);
    }
}
