package tests.account;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.android.account.RequisitesPage;
import steps.LoginSteps;

public class SendRequisitesOnEmptyEmailTest extends LoginSteps {

    @Epic("Счет")
    @Feature("Отправка/Сохранение реквизитов")
    @Story("Отправка реквизитов на пустой Email. Хинт")
    @TmsLink("21820")
    @Test
    public void sendingRequisitesOnEmptyEmailAndHintWorkingTest() {
        SoftAssert softAssert = new SoftAssert();
        var requisitesPage = new RequisitesPage(getAndroidDriver());
        var isDisplayAboutEmpty = personalCabinetMainPage
                .tapOnAccountInBlock()
                .tapOnRequisitesButton()
                .tapOnSaveOrShareButton()
                .tapOnSendToEmail()
                .tapOnSendButton()
                .isDisplayMessageAboutFieldEmpty();
        softAssert.assertTrue(isDisplayAboutEmpty);
        var isDisplayQuestionIcon = requisitesPage
                .tapOnOkButton()
                .isDisplayQuestionIcon();
        softAssert.assertTrue(isDisplayQuestionIcon);
        var isDisplayMessageEmpty = requisitesPage
                .tapOnHintInFieldForInput()
                .isDisplayMessageAboutFieldEmpty();
        softAssert.assertTrue(isDisplayMessageEmpty);
        var isDisplayWithInvalidDataScreen = requisitesPage
                .tapOnOkButton()
                .isDisplayQuestionIcon();
        softAssert.assertTrue(isDisplayWithInvalidDataScreen);
        softAssert.assertAll();
    }
}
