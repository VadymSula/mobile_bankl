package tests.authorization.login;

import tests.authorization.AuthorizationMainTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.authorization.ConfirmLoginPage;

public class AttemptsLimitReachedTest extends AuthorizationMainTest {

    @Epic("Авторизация")
    @Feature("Логин")
    @Story("Ошибка \"Лимит попыток исчерпан\"")
    @TmsLink("9480")
    @Test
    public void attemptsLimitReachedAfterInputOfInvalidCode() {
        ConfirmLoginPage confirmLoginPage = new ConfirmLoginPage(getAndroidDriver());
        loginAndSignInSteps("9990040083167", "1111")
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
