package tests.demoversion.more;

import core.base.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.android.demoversion.more.DemoMorePage;

public class MoreMainTest extends BaseTest {
    protected final DemoMorePage demoMorePage = new DemoMorePage(getAndroidDriver());

    @BeforeClass
    public void goToDemoVersionAndMore() {
        androidBasePage
                .goToDemoVersion()
                .goToMorePage();
    }
}
