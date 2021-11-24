package pages.android.demoversion.more.smsAndEmailNotices;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class PhoneAndEmail extends DemoVersionMainPage {
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ImageView")
    protected MobileElement DELETE_FIRST_NUMBER;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Добавить ещё один номер')]")
    protected MobileElement ADD_NEW_NUMBER;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Добавить ещё один Email')]")
    protected MobileElement ADD_NEW_EMAIL;

    public PhoneAndEmail(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть на 'Удаление номера'")
    public PhoneAndEmail tapOnDeleteFirstNumber() {
        buttons.searchAndClickButtonBy(DELETE_FIRST_NUMBER);
        return this;
    }

    @Step("Тапнуть на 'Добавить еще один номер'")
    public PhoneAddition tapOnNewNumberAddition() {
        buttons.searchAndClickButtonBy(ADD_NEW_NUMBER);
        return new PhoneAddition(getAndroidDriver());
    }

    @Step("Тапнуть на 'Добавить еще один Email'")
    public EmailAddition tapOnNewEmailAddition() {
        buttons.searchAndClickButtonBy(ADD_NEW_EMAIL);
        return new EmailAddition(getAndroidDriver());
    }
}
