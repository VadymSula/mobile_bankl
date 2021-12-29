package tests;

import core.base.BaseTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.android.PersonalCabinetMainPage;
import pages.android.authorization.ConfirmLoginPage;
import pages.android.authorization.LoginPage;
import utils.integration.fimi.SOAPClientSAAJ;

public class LoginSteps extends BaseTest {
    protected final LoginPage loginPage = new LoginPage(getAndroidDriver());
    protected final PersonalCabinetMainPage personalCabinetMainPage = new PersonalCabinetMainPage(getAndroidDriver());

    @BeforeSuite
    //@Parameters({"login", "password"})
    public void login(/*String login, String password*/) {
        loginPage
                .goToSignInPage()
                .tapOnIDOrLoginFieldAndInput("9990040083167")
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
