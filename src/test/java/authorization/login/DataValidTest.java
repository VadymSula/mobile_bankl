package authorization.login;

import authorization.AuthorizationMainTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.authorization.ConfirmLoginPage;

public class DataValidTest extends AuthorizationMainTest {

    @Epic("Авторизация")
    @Feature("Логин")
    @Story("Валидные данные")
    @TmsLink("27316")
    @Test
    public void signInWithValidCredentialsTest(String login, String password) {
        var isDisplaySignInScreen = loginPage.isDisplaySignInScreenAndSections();

        var isDisplayConfirmLoginScreen = loginPage
                .tapOnIDOrLoginFieldAndInput(login)
                .tapOnPasswordFieldAndInput(password)
                .tapOnSignInButton()
                .isDisplaySignInScreenAndSections();

        var isDisplayMainMenu = new ConfirmLoginPage(getAndroidDriver())
                .inputCheckingCodeInFieldByCode()
                .tapOnReadyButton()
                .tapOnFingerPrintCancelButtonIfExistIt()
                .tapRepeatedlyOnOnboardingNextButton()
                .isDisplayMainScreenContent();

        Assert.assertTrue(isDisplaySignInScreen && isDisplayConfirmLoginScreen && isDisplayMainMenu);
    }
}
