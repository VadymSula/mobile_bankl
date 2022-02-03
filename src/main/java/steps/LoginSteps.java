package steps;

import core.InitialDriver;
import core.base.AndroidBasePage;
import core.base.BaseStep;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import pages.android.PersonalCabinetMainPage;
import pages.android.authorization.ConfirmLoginPage;
import pages.android.authorization.LoginPage;
import utils.EnvVariablesGetter;
import utils.integration.fimi.SOAPClientSAAJ;

public class LoginSteps extends BaseStep {
    protected static LoginPage loginPage = new LoginPage(getAndroidDriver());
    protected static PersonalCabinetMainPage personalCabinetMainPage = new PersonalCabinetMainPage(getAndroidDriver());

    @Step("Выбрать стенд и залогиниться")
    public static void chooseTestStandAndLogin(String login, String password) {
        var port = EnvVariablesGetter.getValueFromEnvironmentVariableByKey("TEST_PORT");
        chooseTestStand(port);
        login(login, password);
    }

    @Step("Выбор тестового стенда. Выбран: \"{port}\"")
    public static void chooseTestStand(String port) {
        androidBasePage.tapOnTestSettingsButtonAndChooseStand(port);
    }

    @Step("Валидный вход по логину")
    public static void login(String login, String password) {
        loginPage
                .goToSignInPage()
                .tapOnIDOrLoginFieldAndInput(login)
                .tapOnPasswordFieldAndInput(password)
                .tapOnSignInButton()
                .inputCheckingCodeInFieldByCode(getCheckingCode(login))
                .tapOnReadyButton()
                .tapOnFingerPrintCancelButtonIfExistIt()
                .tapRepeatedlyOnOnboardingNextButton();
    }

    private static String getCheckingCode(String login) {
        return SOAPClientSAAJ.getDynamicCodeByHisNumber(
                new ConfirmLoginPage(getAndroidDriver())
                        .getNumberOfCheckingCode(),
                login
        );
    }
}
