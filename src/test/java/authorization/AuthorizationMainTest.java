package authorization;

import core.base.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.android.authorization.LoginPage;

public class AuthorizationMainTest extends BaseTest {
    protected final LoginPage loginPage = new LoginPage(getAndroidDriver());

    @BeforeClass
    public void goToLoginPage() {
        loginPage
                .goToSignInPage();
    }
}
