package demoversion.more;

import core.base.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.android.demoversion.more.MorePage;

public class MoreMainTest extends BaseTest {
    protected final MorePage morePage = new MorePage(getAndroidDriver());

    @BeforeClass
    public void goToDemoVersionAndMore() {
        androidBasePage
                .goToDemoVersion()
                .goToMorePage();
    }
}
