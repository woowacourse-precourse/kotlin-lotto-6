package lotto.utils

private const val ERROR_NOTICE = "[ERROR] "
enum class ErrorMessage(val message: String) {
    INPUT_IS_NULL(ERROR_NOTICE + "입력 값은 비울 수 없습니다."),
    NOT_NATURAL_NUM(ERROR_NOTICE + "입력 값은 자연수여야 합니다."),
    NOT_INT(ERROR_NOTICE +"입력 값은 숫자여야 합니다."),
    NOT_LOTTO(ERROR_NOTICE + "입력 값은 올바른 로또 번호여야 합니다."),
    NOT_LOTTO_SIZE(ERROR_NOTICE + "올바른 로또 번호 개수가 아닙니다."),
    NOT_NUM_SIZE(ERROR_NOTICE +"입력 값의 최대 자릿수는 10입니다."),
    NOT_DEVIDABLE(ERROR_NOTICE + "1000으로 나누어 떨어지는 값을 입력해 주세요.");
}