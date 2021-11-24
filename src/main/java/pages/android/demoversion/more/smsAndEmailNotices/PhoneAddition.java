package pages.android.demoversion.more.smsAndEmailNotices;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class PhoneAddition extends DemoVersionMainPage {
    @AndroidFindBy(className = "android.widget.EditText")
    protected MobileElement PHONE_NUMBER_EDITTEXT;

    public PhoneAddition(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть в поле 'Номер телефона' и написать номер телефона")
    public PhoneAddition tapOnPhoneNumberFieldAndWriteNumber(String phoneNumber) {
        buttons.searchAndClickButtonBy(PHONE_NUMBER_EDITTEXT);
        elements.sendKeyFromAction(phoneNumber);
        return this;
    }
}
