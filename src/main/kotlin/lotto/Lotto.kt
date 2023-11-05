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

    companion object {
        val VALID_RANGE = 1..46
    }

}
