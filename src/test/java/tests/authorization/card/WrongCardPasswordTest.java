package tests.authorization.card;

import enums.Text;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.authorization.AuthorizationMainTest;

public class WrongCardPasswordTest extends AuthorizationMainTest {


    @Test
    @TmsLink("29888")
    public void insertWrongPassword() {
        String cardNumber  = "4301 8183 7499 6323";
        String password  = "0000";

        Assert.assertTrue(loginPageForLogin
                        .tapOnByCardSectiot()
                        .isDisplaySignInScreenAndSectionsForCard()
                        .tapOnIDOrLoginFieldAndInput(cardNumber.replaceAll("\\s",""))
                        .tapOnPasswordFieldAndInput(password)
                        .tapOnSignInButton()
                        .isExistFailAlertAfterSignIn(Text.INVALID_PASSWORD)
                , String.format("Не отобразилось сообщение \"%s\" ", Text.INVALID_PASSWORD.getText())
        );

    }

}
