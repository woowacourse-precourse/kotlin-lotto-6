package lotto.domain

enum class ErrorType(
    val type: Int,
    val message: String
) {
    IS_NOT_POSITIVE_INTEGER(1,"입력 값이 정수가 아닙니다."),
    IS_INCORRECT_AMOUNT(2,"올바른 로또 구매 금액이 아닙니다."),
    IS_CONTAIN_DUPLICATES(3,"중복 된 로또 번호가 있습니다."),
    IS_INCORRECT_NUMBER(4,"1~45 범위의 로또 번호가 아닙니다."),
    IS_BLANK(5,"빈 값이 입력 되었습니다."),
    IS_NOT_SIX_NUMBERS(6,"로또 번호가 6개가 아닙니다."),
    NOT_ERROR(7,"")
}