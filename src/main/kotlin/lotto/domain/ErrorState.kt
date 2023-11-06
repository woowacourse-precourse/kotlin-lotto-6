package lotto.domain

enum class ErrorState(
    val message: String
) {
    IS_NOT_POSITIVE_INTEGER("구입금액을 입력해 주세요."),
    IS_INCORRECT_AMOUNT("올바른 로또 구매 금액이 아닙니다."),
    IS_CONTAIN_DUPLICATES("중복 된 로또 번호가 있습니다."),
    IS_INCORRECT_NUMBER("1~45 범위의 로또 번호가 아닙니다.")
}