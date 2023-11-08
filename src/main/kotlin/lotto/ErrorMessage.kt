package lotto

private const val ERROR_CONVENTION = "[ERROR] "

enum class ErrorMessage(val msg: String) {
    INPUT_NUMBER(ERROR_CONVENTION + "숫자를 입력해주세요."),
    INPUT_NOT_MINUS(ERROR_CONVENTION + "1 이상의 금액을 입력해주세요"),
    INPUT_THOUSAND(ERROR_CONVENTION + "1,000원 단위 금액을 입력해주세요"),
    MAX_PURCHASE_PRIZE(ERROR_CONVENTION + "구입 최대 금액은 10만원입니다."),
    NOT_STRING(ERROR_CONVENTION + "문자가 아닌 숫자를 입력해주세요."),
    NOT_RANGE(ERROR_CONVENTION + "1~45 사이의 숫자를 입력해주세요."),
    NOT_DUPLICATE(ERROR_CONVENTION + "동일한 번호가 중복되었습니다."),
    NOT_SIX(ERROR_CONVENTION + "6개의 당첨번호를 입력해주세요."),
    NOT_IN_NUMBERS(ERROR_CONVENTION + "보너스 숫자가 당첨번호와 중복됩니다.")
}