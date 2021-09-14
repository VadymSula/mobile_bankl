package pages.android.demoversion.accountsAndDeposits;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class ChooseCardPage extends DemoVersionMainPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Classic')]/..")
    protected MobileElement CLASSIC_CARD;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Platinum Debit')]/..")
    protected MobileElement PLATINUM_DEBIT_CARD;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Добавить')]/..")
    protected MobileElement ADD_NEW_CARD_BUTTON;

    public ChooseCardPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @Step("Тапнуть на карту 'Classic'")
    public FromCardOtherBankPage tapOnTheClassicCard() {
        buttons.searchAndClickButtonBy(CLASSIC_CARD);
        return new FromCardOtherBankPage(getAppiumDriver());
    }
}
