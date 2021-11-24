package pages.android.demoversion.more;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import pages.android.demoversion.DemoVersionMainPage;

public class PersonalDataPage extends DemoVersionMainPage {

    @AndroidFindBy(id = "cb.ibank:id/view_controller_personal_data_code_word_button")
    protected MobileElement CODE_WORD_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_code_word_show_action")
    protected MobileElement SHOW_CODE_WORD_BUTTON;
    @AndroidFindBy(id = "cb.ibank:id/view_controller_code_word_edit_action_button")
    protected MobileElement EDIT_CODE_WORD_BUTTON;

    public PersonalDataPage(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    @Step("Тапнуть на 'кодовое слово'")
    public PersonalDataPage tapOnCodeWordButton() {
        buttons.searchAndClickButtonBy(CODE_WORD_BUTTON);
        return this;
    }

    @Step("Тапнуть на 'Показать'")
    public PersonalDataPage tapOnShowCodeWord() {
        buttons.searchAndClickButtonBy(SHOW_CODE_WORD_BUTTON);
        return this;
    }

    @Step("Тапнуть на 'Изменить кодовое слово'")
    public PersonalDataPage tapOnEditCodeWord() {
        buttons.searchAndClickButtonBy(EDIT_CODE_WORD_BUTTON);
        return this;
    }
}
