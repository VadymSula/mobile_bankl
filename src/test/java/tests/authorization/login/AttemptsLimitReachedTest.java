package tests.authorization.login;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.android.authorization.ConfirmLoginPage;
import tests.authorization.AuthorizationMainTest;

public class AttemptsLimitReachedTest extends AuthorizationMainTest {

    @Epic("Авторизация")
    @Feature("Логин")
    @TmsLink("9480")
    @Test(description = "Ошибка \"Лимит попыток исчерпан\"")
    @Parameters({"login", "password"})
    public void attemptsLimitReachedAfterInputOfInvalidCode(String login, String password) {
        ConfirmLoginPage confirmLoginPage = new ConfirmLoginPage(getAndroidDriver());
        loginAndSignInSteps(login, password)
                .inputCheckingCodeInFieldByCode("0000")
                .tapOnReadyButton();
        var isDisplayFailMessage = confirmLoginPage.isContainsMessageAboutInvalidCode();
        confirmLoginPage.tapOnOkButton();
        boolean isDisplayMessageAboutLimit = false;
        try {
            isDisplayMessageAboutLimit = isExistLimitMessageAfterInputsInvalidCodeUntilThrowsAlert(confirmLoginPage, "0000") &&
                    confirmLoginPage.isDisplayCallToBankAndOkButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
        confirmLoginPage.tapOnOkButton();
        var isDisplayAlertAboutBlock =
                //loginAndSignInSteps("9990040083167", "1111")
                loginPage
                .tapOnSignInButton()
                .isDisplayAlertAboutAccessTempBlockMessage() && confirmLoginPage.isDisplayCallToBankAndOkButton();

        Assert.assertTrue(isDisplayFailMessage && isDisplayMessageAboutLimit && isDisplayAlertAboutBlock);
    }

    private boolean isExistLimitMessageAfterInputsInvalidCodeUntilThrowsAlert(ConfirmLoginPage confirmLoginPage, String code) throws Exception{
        do {
            inputCheckingCodeAndTapOnReadyButton(confirmLoginPage, code);
            if (confirmLoginPage.isContainsMessageAboutInvalidCode()) {
                confirmLoginPage.tapOnOkButton();
            } else {
                break;
            }
        } while (true);
        return true;
    }

    private void inputCheckingCodeAndTapOnReadyButton(ConfirmLoginPage confirmLoginPage, String code) {
        confirmLoginPage
                .inputCheckingCodeInFieldByCode(code)
                .tapOnReadyButton();
    }

    private ConfirmLoginPage loginAndSignInSteps(String login, String password) {
        return loginPage
                .tapOnIDOrLoginFieldAndInput(login)
                .tapOnPasswordFieldAndInput(password)
                .tapOnSignInButton();
    }
}
