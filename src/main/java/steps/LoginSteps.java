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
    //private static final String KEY = EnvVariablesGetter.getValueFromEnvironmentVariableByKey("TEST_PORT");
    protected static LoginPage loginPage = new LoginPage(getAndroidDriver());
    protected static PersonalCabinetMainPage personalCabinetMainPage = new PersonalCabinetMainPage(getAndroidDriver());

    @Step("Выбрать стенд и залогиниться")
    public static void chooseTestStandAndLogin() {
        chooseTestStand();
        login();
    }

    @Step("Выбор тестового стенда. Выбран: \"{KEY1}\"")
    public static void chooseTestStand() {
        var KEY1 = "Dev2";
        androidBasePage.tapOnTestSettingsButtonAndChooseStand(KEY1);
    }

    @Step("Валидный вход по логину")
    public static void login(/*String login, String password*/) {
        loginPage
                .goToSignInPage()
                .tapOnIDOrLoginFieldAndInput("99900704114373")
                .tapOnPasswordFieldAndInput("1111")
                .tapOnSignInButton()
                //.inputCheckingCodeInFieldByCode(getCheckingCode())
                .tapOnReadyButton()
                .tapOnFingerPrintCancelButtonIfExistIt()
                .tapRepeatedlyOnOnboardingNextButton();
    }

    private String getCheckingCode() {
        return SOAPClientSAAJ.getDynamicCodeByHisNumber(
                new ConfirmLoginPage(getAndroidDriver())
                        .getNumberOfCheckingCode()
        );
    }
}
