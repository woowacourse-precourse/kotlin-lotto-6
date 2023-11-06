package lotto.util

object Validation {

    fun validatePurchaseAmount(amount: String) {

        require(amount.isNotEmpty())
        { "[ERROR] 빈 칸은 입력할 수 없습니다." }

        require(amount.toIntOrNull() != null)
        { "[ERROR] 숫자만 입력 가능합니다." }

        require((amount.toInt() % 1000 == 0) && (amount.toInt() > 0))
        { "[ERROR] 금액은 1,000원 단위로만 입력 가능합니다." }

    }

    fun validateDuplicateNumbers(numbers: List<Int>): Boolean {

        val set = HashSet<Int>()
        for (number in numbers) {
            if (set.contains(number)) {

                return true
            }
            set.add(number)
        }
        return false
    }

}