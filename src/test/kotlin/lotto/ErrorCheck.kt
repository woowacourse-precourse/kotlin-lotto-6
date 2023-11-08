package lotto

enum class ErrorCheck(val isValid: Boolean, val message: String) {
    VALID(true, "결제되었습니다."),
    INVALID_FORMAT(false, "[ERROR] 돈을 입력하세요."),
    INVALID_RANGE(false, "[ERROR] 양수 값을 입력해주세요."),
    INVALID_AMOUNT(false, "[ERROR] 1000원 단위로 구입금액을 재입력해 주세요.");

    companion object {
        fun checkMoney(money: String): ErrorCheck {
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