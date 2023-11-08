package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { Message.ERROR_RANDOM_NUMBER_SIX_RANGE }
        requireRandomNumberDuplicate()
        requireRandomNumberValidRange()
        requireRandomNumberAscendingOrder()
    }

    private fun requireRandomNumberDuplicate() {
        val uniqueNumbers = HashSet<Int>()
        for (number in numbers) {
            require(uniqueNumbers.add(number)) { Message.ERROR_RANDOM_NUMBER_DUPLICATION }
        }
    }

    private fun requireRandomNumberValidRange() {
        for (number in numbers) {
            require(number in VALID_RANGE) { Message.ERROR_RANDOM_NUMBER_RANGE }
        }
    }

    private fun requireRandomNumberAscendingOrder() {
        for (i in 1 until numbers.size) {
            require(numbers[i] > numbers[i - 1]) { Message.ERROR_RANDOM_NUMBER_SORTING }
        }
    }

    fun formatNumbers(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }

    fun checkMatchWinCount(winningNumbers: LottoWinningNumbers): WinCount {
        val matchingNumbers = numbers.intersect(winningNumbers.userPickNumbers.toSet()).count()
        val bonusMatch = numbers.contains(winningNumbers.bonusNumber)
        return WinCount(matchingNumbers, bonusMatch)
    }

    companion object {
        private val VALID_RANGE = 1..45
    }

}
