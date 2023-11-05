package lotto.domain

enum class ValidatorPayment(val isValid: Boolean, val message: String) {
    VALID(true, "유효한 지불 금액입니다."),
    INVALID_FORMAT(false, "[ERROR] 1000원 단위의 숫자로만 구입금액을 재입력해 주세요."),
    INVALID_RANGE(false, "[ERROR] 1000원 단위의 양수 구입금액을 재입력해 주세요."),
    INVALID_AMOUNT(false, "[ERROR] 1000원 단위로 구입금액을 재입력해 주세요.");

    companion object {
        fun checkMoney(money: String): ValidatorPayment {
            val moneyToCheck = money.toIntOrNull()
            return when {
                moneyToCheck == null -> INVALID_FORMAT
                moneyToCheck < 0 -> INVALID_RANGE
                moneyToCheck % 1000 != 0 -> INVALID_AMOUNT
                else -> VALID

            }
        }
    }
}