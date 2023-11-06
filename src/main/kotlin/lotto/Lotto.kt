package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun matchingNumbers(list: Set<Int>): Int {
        var matchedNumbersCount = 0
        for (number in numbers) {
            matchedNumbersCount += isMatchedNumber(number, list)
        }
        return matchedNumbersCount
    }

    private fun isMatchedNumber(number: Int, list: Set<Int>): Int {
        if (list.contains(number)) {
            return 1
        }
        return 0
    }

    fun matchingBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
