package pages.android;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.account.AccountPage;
import pages.android.paymentsAndTransfers.PaymentsAndTransfersPage;

public class PersonalCabinetMainPage extends AndroidBasePage {

    @AndroidFindBy(id = "cb.ibank:id/dialog_fingerprint_cancel")
    protected MobileElement FINGERPRINT_CANCEL_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/main_screen_content")
    protected MobileElement MAIN_SCREEN_CONTENT;
    @AndroidFindBy(id = "cb.ibank:id/common_dialog_button_cancel")
    protected MobileElement CANCEL_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Счета и вклады']/../descendant::android.widget.FrameLayout[1]")
    protected MobileElement FIRST_ACCOUNT;
    @AndroidFindBy(id = "cb.ibank:id/account_name")
    protected MobileElement ACCOUNT_NAME;
    @AndroidFindBy(id = "cb.ibank:id/main_navigation_main_action_button")
    protected MobileElement PAYMENTS_BUTTON;

    public PersonalCabinetMainPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Отображается главный экран\n" +
            "Пользователь вошел в личный кабинет")
    public boolean isDisplayMainScreenContent() {
        return elements.isElementExist(MAIN_SCREEN_CONTENT);
    }

    public PersonalCabinetMainPage tapOnFingerPrintCancelButtonIfExistIt() {
        if (elements.isElementExist(FINGERPRINT_CANCEL_BUTTON, 40L)) {
            buttons.searchAndClickButtonBy(FINGERPRINT_CANCEL_BUTTON);
        }
        return this;
    }
    //TODO поправить под кол-во шагов онбординга
    public PersonalCabinetMainPage tapRepeatedlyOnOnboardingNextButton() {
        for (var i = 0; i < 4; i++) {
            buttons.searchAndClickButtonBy(ONBOARDING_NEXT_BUTTON);
        }
        return this;
    }

    @Step("Тапнуть на счёт в блоке \"Счета и вклады\"")
    public AccountPage tapOnAccountInBlock() {
        buttons.searchAndClickButtonByCoordinates(ACCOUNT_NAME);
        return new AccountPage(getAndroidDriver());
    }

    @Step("Тапнуть на \"Платежи\"")
    public PaymentsAndTransfersPage tapOnPaymentsButton() {
        buttons.searchAndClickButtonBy(PAYMENTS_BUTTON);
        return new PaymentsAndTransfersPage(getAndroidDriver());
    }

}
