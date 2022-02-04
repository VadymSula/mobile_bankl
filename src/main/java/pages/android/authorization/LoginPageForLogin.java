package pages.android.authorization;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class LoginPageForLogin extends LoginPage {


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

    private static LoginPageForLogin instance;

    private LoginPageForLogin(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    public static LoginPageForLogin getLoginPageForLogin(AndroidDriver<MobileElement> androidDriver) {
        if (instance == null) {
            return new LoginPageForLogin(androidDriver);
        }
        return instance;
    }

    // TODO: 04.02.2022 Переписать проверку наличия элементов на экране
    @Step("Отображается экран входа в МБ, разделы")
    public boolean isDisplaySignInScreenAndSections() {
        return isDisplayScreenWithFormForLogin() &&
                isExistByLoginSection() &&
                isExistByCardSection() &&
                isDisplayTitle() &&
                isDisplayIDOrLoginField() &&
                isDisplayPasswordField() &&
                isDisplayForgotLoginOrPasswordAndSignInButton();
    }


    @Step("Тапнуть на поле \"Идентификатор / логин\"" +
            "Ввести логин ({idOrLogin})")
    public LoginPageForLogin tapOnIDOrLoginFieldAndInput(String idOrLogin) {
        buttons.searchAndClickButtonBy(LOGIN_TEXTFIELD);
        elements.sendKeyFromAction(idOrLogin);
        return this;
    }

    @Step("Тапнуть на поле \"Пароль\"" +
            "Ввести пароль ({password})")
    public LoginPageForLogin tapOnPasswordFieldAndInput(String password) {
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


    @Step("Отображается раздел \"По логину\"")
    protected boolean isExistByLoginSection() {
        return elements.isElementExist(BY_LOGIN_SECTION)
                && elements.isSelectedElement(BY_LOGIN_SECTION);
    }

    @Step("Отображается раздел \"По карте\"")
    protected boolean isExistByCardSection() {
        return elements.isElementExist(BY_CARD_SECTION)
                && !elements.isSelectedElement(BY_CARD_SECTION);
    }

    @Step("Отображается заголовок \"Вход в мобильный банк по логину\"")
    protected boolean isDisplayTitle() {
        return elements.isElementExist(LOGIN_TITLE)
                && LOGIN_TITLE.getText().equals("Вход в мобильный банк по логину");
    }

    @Step("Отображается поле \"Идентификатор / логин\"")
    private boolean isDisplayIDOrLoginField() {
        return elements.isElementExist(LOGIN_TEXTFIELD)
                && LOGIN_TEXTFIELD.getText().equals("Идентификатор / логин");
    }

    @Step("Отображается поле \"Пароль\"")
    private boolean isDisplayPasswordField() {
        return elements.isElementExist(PASSWORD_TEXTFIELD)
                && PASSWORD_TEXTFIELD.getText().equals("Пароль");
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
