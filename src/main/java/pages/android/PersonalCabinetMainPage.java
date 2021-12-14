package pages.android;

import core.base.AndroidBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class PersonalCabinetMainPage extends AndroidBasePage {

    @AndroidFindBy(id = "cb.ibank:id/dialog_fingerprint_cancel")
    protected MobileElement FINGERPRINT_CANCEL_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/tutorial_view_next_button")
    protected MobileElement ONBOARDING_NEXT_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/main_screen_content")
    protected MobileElement MAIN_SCREEN_CONTENT;

    public PersonalCabinetMainPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Отображается главный экран\n" +
            "Пользователь вошел в личный кабинет")
    public boolean isDisplayMainScreenContent() {
        return elements.isElementExist(MAIN_SCREEN_CONTENT);
    }

    public PersonalCabinetMainPage tapOnFingerPrintCancelButtonIfExistIt() {
        if (elements.isElementExist(FINGERPRINT_CANCEL_BUTTON)) {
            buttons.searchAndClickButtonBy(FINGERPRINT_CANCEL_BUTTON);
        }
        return this;
    }

    public PersonalCabinetMainPage tapRepeatedlyOnOnboardingNextButton() {
        for (var i = 0; i < 4; i++) {
            buttons.searchAndClickButtonBy(ONBOARDING_NEXT_BUTTON);
        }
        return this;
    }

}
