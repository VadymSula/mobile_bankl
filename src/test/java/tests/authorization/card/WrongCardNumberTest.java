package tests.authorization.card;

import enums.Text;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.authorization.AuthorizationMainTest;


public class WrongCardNumberTest extends AuthorizationMainTest {

    @Test
    @TmsLink("29887")
    public void insertWrongCardNumber() {

        Assert.assertTrue(loginPageForLogin
                        .tapOnByCardSectiot()
                        .isDisplaySignInScreenAndSectionsForCard()
                        .tapOnIDOrLoginFieldAndInput("1234")
                        .tapOnPasswordFieldAndInput("1234")
                        .tapOnSignInButton()
                        .isExistFailAlertAfterSignIn(Text.INVALID_FILLING_FIELDS)
                , String.format("Не отобразилось сообщение \"%s\" ", Text.INVALID_FILLING_FIELDS.getText())
                );

    }


}
