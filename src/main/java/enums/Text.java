package enums;

public enum Text {

    FAST_PAYMENTS_TITLE_TEXT("Быстрые платежи"),
    FAST_PAYMENT_MESSAGE_TEXT("Все успешно выполненные операции временно сохраняются в меню быстрых платежей. По нажатию на ярлык быстрого платежа можно перейти к оплате без необходимости заполнять данные заново"),
    PAYMENT_BY_QR_CODE_MESSAGE("Отсканируйте его на квитанции ЖКХ или другом счете, и мы сами заполним все данные. Либо воспользуйтесь функцией сканирования из файла, если ваша квитанция сохранена в фотогалереи.PAYMENT_BY_QR_CODE_TITLE=Как оплачивать по QR-коду"),
    INVALID_FILLING_FIELDS("Необходимо корректно заполнить все поля"),
    FIELD_NOT_MAY_BE_EMPTY("Поле ввода не может быть пустым"),
    INVALID_PASSWORD("Введен неправильный пароль.Пожалуйста, авторизуйтесь снова.");
    private final String text;

    Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
