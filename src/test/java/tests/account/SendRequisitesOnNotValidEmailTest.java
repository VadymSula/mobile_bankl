package tests.account;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.account.RequisitesPage;
import tests.LoginSteps;

public class SendRequisitesOnNotValidEmailTest extends LoginSteps {

    @Epic("Счет")
    @Feature("Отправка/Сохранение реквизитов")
    @Story("Отправка реквизитов счета на не валидный Email. Нет привязанной почты")
    @TmsLink("21913")
    @Test
    public void sendingRequisitesOfAccountToEmailNotValidAndNotExistEmail() {
        var actualResult = personalCabinetMainPage
                .tapOnAccountInBlock()
                .tapOnRequisitesButton()
                .tapOnSaveOrShareButton()
                .tapOnSendToEmail()
                .inputIncorrectEmailInFieldAndClickOnEnter("aiaosdaoisjdasd")
                .isDisplayQuestionIcon();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 1)
    public void isExistMessageAboutIncorrectEmail() {
        var actualResult = new RequisitesPage(getAndroidDriver())
                .tapOnSendButton()
                .isDisplayMessageAboutIncorrectEmail();

        Assert.assertTrue(actualResult);
    }

    @Test(priority = 2)
    public void isDisplayQuestionIconAgain() {
        var actualResult = new RequisitesPage(getAndroidDriver())
                .tapOnOkButton()
                .isDisplayQuestionIcon();

        Assert.assertTrue(actualResult);
    }




}
