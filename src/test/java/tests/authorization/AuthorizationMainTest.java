package tests.authorization;

import core.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import pages.android.authorization.LoginPageForLogin;

public class AuthorizationMainTest extends BaseTest {
    protected final LoginPageForLogin loginPageForLogin = LoginPageForLogin.getLoginPageForLogin(getAndroidDriver());

    @BeforeMethod
    public void goToLoginPage() {
        getAndroidDriver().launchApp();
        loginPageForLogin
                .goToSignInPage();
    }
}
