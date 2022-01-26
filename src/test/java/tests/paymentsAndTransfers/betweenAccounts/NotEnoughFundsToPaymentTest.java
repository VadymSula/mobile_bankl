package tests.paymentsAndTransfers.betweenAccounts;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.paymentsAndTransfers.BetweenAccountsPage;

public class NotEnoughFundsToPaymentTest extends PaymentsAndTransfersBaseTest {

    @Epic("Платежи и переводы")
    @Feature("Переводы между счетами")
    @Story("Недостаточно средств")
    @TmsLink("27211")
    @Test
    public void notEnoughFundsToPaymentsBetweenAccountsTest() {
        SoftAssert softAssert = new SoftAssert();
        var betweenAccountsPage = new BetweenAccountsPage(getAndroidDriver());

        stepToChooseAccountRecipient(softAssert, betweenAccountsPage);
        var isDisplayModalForAccountRecipient = betweenAccountsPage
                .tapOnAvailableAccount()
                .tapOnAccountRecipient()
                .isDisplayModalWindowWithTransferForAccountRecipient();
        softAssert.assertTrue(isDisplayModalForAccountRecipient);
        var isDisplayModalTransferDetail = betweenAccountsPage
                .tapOnAvailableAccountForRecipient()
                .fillSumFieldOverSumOnAccountTransferFrom()
                .tapOnTransferButtonOnModalWindow()
                .isDisplayPopUpAboutIncorrectFilling();
        softAssert.assertTrue(isDisplayModalTransferDetail);
        var isDisplayHintInSumField = betweenAccountsPage
                .tapOnOkButtonAfterIncorrectFilling()
                .isDisplayHintInSumField();
        softAssert.assertTrue(isDisplayHintInSumField);
        softAssert.assertAll();
    }
}
