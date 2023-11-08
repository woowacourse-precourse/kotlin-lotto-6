package lotto

class ExceptionManager {

    fun moneyException(num: String) {
        val money = num.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.INPUT_NUMBER.msg)
        require(money >= 1) { ErrorMessage.INPUT_NOT_MINUS.msg }
        require(money % 1000 == 0) { ErrorMessage.INPUT_THOUSAND.msg }
        require(money <= 100000) { ErrorMessage.MAX_PURCHASE_PRIZE.msg }
    }

    fun winningNumberException(nums: List<String>) {
        val numbers = mutableListOf<Int>()

        for (num in nums) {
            val convertedNum = num.toIntOrNull()
            convertedNum?.let {
                numbers.add(convertedNum)
            } ?: throw IllegalArgumentException(ErrorMessage.NOT_STRING.msg)
        }

        for (index in numbers) {
            if (index > 45 || index < 1) {
                throw IllegalArgumentException(ErrorMessage.NOT_RANGE.msg)
            }
        }
        require(numbers.distinct().size == numbers.size) { ErrorMessage.NOT_DUPLICATE.msg }
        require(numbers.distinct().size == 6) { ErrorMessage.NOT_SIX.msg }
    }

    fun bonusNumberException(pair: Pair<List<String>, String>) {
        val convertedNum = pair.second.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.NOT_STRING.msg)
        require(convertedNum in 1..45) { ErrorMessage.NOT_RANGE.msg }

        if (pair.second in pair.first) {
            throw IllegalArgumentException(ErrorMessage.NOT_IN_NUMBERS.msg)
        }
    }
}