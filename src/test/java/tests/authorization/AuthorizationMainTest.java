package tests.authorization;

import core.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import pages.android.authorization.LoginPageForCard;
import pages.android.authorization.LoginPageForLogin;

public class AuthorizationMainTest extends BaseTest {
    protected final LoginPageForLogin loginPageForLogin = LoginPageForLogin.getLoginPageForLogin(getAndroidDriver());
    protected final LoginPageForCard loginPageForCard = LoginPageForCard.getLoginPageForCard(getAndroidDriver());

    @BeforeMethod
    public void goToLoginPage() {
        getAndroidDriver().launchApp();
        loginPageForLogin
                .goToSignInPage();
    }
}
