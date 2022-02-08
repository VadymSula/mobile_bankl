package tests;

import core.base.BaseTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import steps.autorization.LoginSteps;

public class AuthorizationStep extends BaseTest {

    @BeforeSuite
    @Parameters({"login", "password"})
    public void authorizeByLogin(String login, String password) {
        LoginSteps.login(login, password);
    }
}
