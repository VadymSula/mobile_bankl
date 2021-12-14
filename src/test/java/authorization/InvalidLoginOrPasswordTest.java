package authorization;

import core.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.authorization.LoginPage;

public class InvalidLoginOrPasswordTest extends BaseTest {
    private static final String INVALID_LOGIN = "11112";
    private static final String INVALID_PASSWORD = "11112";
    private final LoginPage loginPage = new LoginPage(getAndroidDriver());


}
