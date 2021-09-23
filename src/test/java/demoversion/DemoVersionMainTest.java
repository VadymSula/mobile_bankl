package demoversion;

import core.base.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.android.demoversion.accountsAndDeposits.AccountPage;

public class DemoVersionMainTest extends BaseTest {
    protected final AccountPage accountPage = new AccountPage(getAndroidDriver());

    @BeforeClass
    public void goToDemoVersion() {
        androidBasePage
                .goToDemoVersion();
    }
}
