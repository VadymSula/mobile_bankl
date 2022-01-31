package tests;

import core.base.BaseTest;
import org.testng.annotations.BeforeSuite;
import steps.LoginSteps;

public class AuthorizationStep extends BaseTest {

    @BeforeSuite
    public void authorizeByLogin() {
        LoginSteps.login();
    }
}
