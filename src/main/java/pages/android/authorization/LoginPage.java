package pages.android.authorization;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class LoginPage extends AndroidBasePage {
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
    @AndroidFindBy(id = "cb.ibank:id/view_progress_button_text")
    protected MobileElement PROGRESS_BUTTON;

    public LoginPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Отображается экран входа в МБ, разделы")
    public boolean isDisplaySignInScreenAndSections() {
        return isDisplayScreenWithFormForLogin() &&
                isExistAndActiveByLoginSection() &&
                isExistByCardSection() &&
                isDisplayLoginTitle() &&
                isDisplayIDOrLoginField() &&
                isDisplayPasswordField() &&
                isDisplayForgotLoginOrPasswordAndSignInButton();
    }

    @Step("Тапнуть на поле \"Идентификатор / логин\"" +
            "Ввести логин ({idOrLogin})")
    public LoginPage tapOnIDOrLoginFieldAndInput(String idOrLogin) {
        buttons.searchAndClickButtonBy(LOGIN_TEXTFIELD);
        elements.sendKeyFromAction(idOrLogin);
        return this;
    }

    @Step("Тапнуть на поле \"Пароль\"" +
            "Ввести пароль ({password})")
    public LoginPage tapOnPasswordFieldAndInput(String password) {
        buttons.searchAndClickButtonBy(PASSWORD_TEXTFIELD);
        elements.sendKeyFromAction(password);
        return this;
    }

    @Step("Тап на кнопку 'Войти'")
    public ConfirmLoginPage tapOnSignInButton() {
        buttons.searchAndClickButtonBy(SIGN_IN_BUTTON);
        return new ConfirmLoginPage(getAndroidDriver());
    }

    @Step(USER_IS_NOT_EXIST_ALERT_TEXT)
    public boolean isExistFailAlertAfterSignIn() {
        var textFromAlert = elements.getTextFromElement(COMMON_DIALOG_TEXT);

        return textFromAlert.contains(PART_OF_ALERT_MESSAGE_ABOUT_NON_EXIST_USER);
    }

    @Step("Кнопка 'Ок' отображается на экране")
    public boolean isExistOKButtonOnScreen() {
        return elements.isElementExist(PROGRESS_BUTTON);
    }

    @Step("Отображается экран входа в МБ")
    private boolean isDisplayScreenWithFormForLogin() {
        return elements.isElementExist(FORM_CONTAINER);
    }

    @Step("Отображается раздел \"По логину\" (по умолчанию)")
    private boolean isExistAndActiveByLoginSection() {
        return elements.isElementExist(BY_LOGIN_SECTION) && elements.isSelectedElement(BY_LOGIN_SECTION);
    }

    @Step("Отображается раздел \"По карте\"")
    private boolean isExistByCardSection() {
        return elements.isElementExist(BY_CARD_SECTION);
    }

    @Step("Отображается заголовок \"Вход в мобильный банк по логину\"")
    private boolean isDisplayLoginTitle() {
        return elements.isElementExist(LOGIN_TITLE);
    }

    @Step("Отображается поле \"Идентификатор / логин\"")
    private boolean isDisplayIDOrLoginField() {
        return elements.isElementExist(LOGIN_TEXTFIELD);
    }

    @Step("Отображается поле \"Пароль\"")
    private boolean isDisplayPasswordField() {
        return elements.isElementExist(PASSWORD_TEXTFIELD);
    }

    @Step("Отображаются кнопки \"Забыли логин или пароль?\" и \"Войти\"")
    private boolean isDisplayForgotLoginOrPasswordAndSignInButton() {
        var isExistForgotButton = elements.isElementExist(FORGOT_LOGIN_OR_PASSWORD_BUTTON);
        var isExistSignInButton = elements.isElementExist(SIGN_IN_BUTTON);

        return isExistSignInButton && isExistForgotButton;
    }

    @Step("В полях формы присутствует плейсхолдер")
    private boolean isExistPlaceholdersInForm() {
        return elements.isElementExist(LOGIN_PLACEHOLDER) && elements.isElementExist(PASSWORD_PLACEHOLDER);
    }


}
