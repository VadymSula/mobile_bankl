package pages.android.mainscreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import core.base.AndroidBasePage;

public class BecomeClientPage extends AndroidBasePage {
    @AndroidFindBy(id = "cb.ibank:id/view_controller_choose_product_switcher")
    protected MobileElement BECOME_CLIENT_CONTAINER;

    public BecomeClientPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public boolean isExistBecomeClientContainer() {
        return elements.isElementExist(BECOME_CLIENT_CONTAINER);
    }
}

