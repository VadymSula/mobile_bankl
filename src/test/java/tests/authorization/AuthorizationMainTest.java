package tests.authorization;

import core.base.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.android.authorization.LoginPageForLogin;

public class AuthorizationMainTest extends BaseTest {
    protected final LoginPageForLogin loginPageForLogin = LoginPageForLogin.getLoginPageForLogin(getAndroidDriver());

    @BeforeClass
    public void goToLoginPage() {
        loginPageForLogin
                .goToSignInPage();
    }
}
