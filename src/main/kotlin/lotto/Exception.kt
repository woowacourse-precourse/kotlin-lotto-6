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
        if (numbers != null && numbers.size == 6 && numbers.all { it in 1..45 } && numbers.toSet().size == numbers.size) {
            return numbers
        } else {
            throw IllegalArgumentException("[ERROR] 올바른 당첨 번호를 입력해주세요.")
        }
    }

    fun enterBonusNumberException(input: String?, winningNumbers: List<Int>): Int {
        val number = input?.toIntOrNull()
        if (number != null && number in 1..45 && number !in winningNumbers) {
            return number
        } else {
            throw IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자 중에서 당첨 번호와 중복되지 않게 입력해주세요.")
        }
    }

}