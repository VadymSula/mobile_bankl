package authorization;

import core.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.authorization.singin.SignInByLogin;

public class InvalidLoginOrPasswordTest extends BaseTest {
    private static final String INVALID_LOGIN = "11112";
    private static final String INVALID_PASSWORD = "11112";
    private final SignInByLogin signInByLogin = new SignInByLogin(getAppiumDriver());

    @Test
    public void isVisibleScreenWithForm() {
        signInByLogin
                .goToSignInPage();
        var actualResult = signInByLogin.isVisibleScreenWithFormForLogin();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void isVisibleLoginTitleAndPlaceholders() {
        signInByLogin
                .tapOnLoginSection();
        var actualResult = signInByLogin.isVisibleLoginTitle() && signInByLogin.isExistPlaceholdersInForm();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 2)
    public void isVisibleAlertMessageAboutUserNonExistingAndButtonOKAfterInputData() {
        signInByLogin
                .fullInFieldsForLoginNotValidData(INVALID_LOGIN, INVALID_PASSWORD)
                .tapOnSignInButton();
        var actualResult = signInByLogin.isExistFailAlertAfterSignIn() && signInByLogin.isExistOKButtonOnScreen() ;

        Assert.assertTrue(actualResult);
    }
}
