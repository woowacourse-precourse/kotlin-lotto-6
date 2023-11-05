package lotto

object Exception {

    fun purchaseAmountEntryException(input: String?): Int? {
        if (input.isNullOrEmpty() || !input.all { it.isDigit() }) {
            throw IllegalArgumentException("[ERROR] 올바른 값을 입력해 주세요.")
        }
        val amount = input.toInt()
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입 금액을 1,000원 단위로 입력해 주세요.")
        }
        return amount
    }

    fun enterWinningNumberException(input: String?): List<Int> {
        val numbers = input?.split(",")?.map { it.trim().toInt() }
        if (numbers != null && numbers.size == 6 && numbers.all { it in 1..45 }) {
            return numbers
        } else {
            throw IllegalArgumentException("[ERROR] 올바른 당첨 번호를 입력해주세요.")
        }
    }
}