package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        requireDuplicateLottoNumber()
        requireValidRange()
        requireAscendingOrder()
    }

    private fun requireDuplicateLottoNumber() {
        val uniqueNumbers = HashSet<Int>()
        for (number in numbers) {
            require(uniqueNumbers.add(number))
        }
    }

    private fun requireValidRange() {
        for (number in numbers) {
            require(number in VALID_RANGE)
        }
    }

    private fun requireAscendingOrder() {
        for (i in 1 until numbers.size) {
            require(numbers[i] > numbers[i - 1])
        }
    }

    fun formatNumbers(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }

    fun checkMatchWinCount(lottery: List<Int>, bonusNumber: Int): WinCount {
        val matchingNumbers = numbers.intersect(lottery.toSet()).count()
        val bonusMatch = numbers.contains(bonusNumber)
        return WinCount(matchingNumbers, bonusMatch)
    }

    companion object {
        private val VALID_RANGE = 1..45
    }

}
