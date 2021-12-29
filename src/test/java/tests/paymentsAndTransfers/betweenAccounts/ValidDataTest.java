package tests.paymentsAndTransfers.betweenAccounts;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.paymentsAndTransfers.BetweenAccountsPage;
import pages.android.paymentsAndTransfers.PaymentsAndTransfersPage;
import tests.LoginSteps;

public class ValidDataTest extends LoginSteps {

    @Epic("Платежи и переводы")
    @Feature("Переводы между счетами")
    @Story("Валидные данные")
    @TmsLink("10392")
    @Test
    public void betweenAccountsValidDataTest() {
        SoftAssert softAssert = new SoftAssert();
        var paymentsAndTransfersPage = new PaymentsAndTransfersPage(getAndroidDriver());
        var betweenAccountsPage = new BetweenAccountsPage(getAndroidDriver());

        var isDisplayFastPaymentOnboarding = personalCabinetMainPage
                .tapOnPaymentsButton()
                .isDisplayOnboardingAboutFastPayment();
        softAssert.assertTrue(isDisplayFastPaymentOnboarding);
        var isDisplayPaymentsOnboarding = paymentsAndTransfersPage
                .tapOnNextAfterFastPaymentOnboardingButton()
                .isDisplayOnboardingAboutPayments();
        softAssert.assertTrue(isDisplayPaymentsOnboarding);
        var isDisplayPaymentsAndTransfersScreen = paymentsAndTransfersPage
                .tapOnNextPaymentByQRCodeOnboardingButton()
                .isDisplayPaymentsScreenWithSections();
        softAssert.assertTrue(isDisplayPaymentsAndTransfersScreen);
        var isDisplayBetweenAccountsScreen = paymentsAndTransfersPage
                .tapOnBetweenAccountsIcon()
                .isDisplayBetweenAccountsScreen();
        softAssert.assertTrue(isDisplayBetweenAccountsScreen);
        var isDisplayModalWindow = betweenAccountsPage
                .tapOnAccountTransferFrom()
                .isExistModalWindowWithTransferFromAccount();
        softAssert.assertTrue(isDisplayModalWindow);
        var isDisplayModalForAccountRecipient = betweenAccountsPage
                .tapOnAvailableAccount()
                .tapOnAccountRecipient()
                .isDisplayModalWindowWithTransferForAccountRecipient();
        softAssert.assertTrue(isDisplayModalForAccountRecipient);
        var isDisplayModalTransferDetail = betweenAccountsPage
                .tapOnAvailableAccountForRecipient()
                .tapOnSumFieldAndFillAndTapOnTransferButton("100")
                .isDisplayModalWindowWithTransferDetails("100");
        softAssert.assertTrue(isDisplayModalTransferDetail);
        var isDisplaySuccessScreen = betweenAccountsPage
                .tapOnTransferButtonOnModalWindow()
                .isDisplaySuccessScreen();
        betweenAccountsPage.tapOnBackToPaymentsButton();
        softAssert.assertTrue(isDisplaySuccessScreen);
        softAssert.assertAll();
    }
}
