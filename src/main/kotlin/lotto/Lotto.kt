package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(isDuplicateNum()) { println(IS_DUPLICATE_NUM) }
        require(checkNotIn1to45()) { println(NOT_IN_ONE_TO_FOURTY_FIVE) }
    }

    private fun isDuplicateNum(): Boolean = numbers.size == numbers.distinct().size
    private fun checkNotIn1to45(): Boolean = numbers.all { it in 1..45 }

    companion object {
        const val IS_DUPLICATE_NUM = "[ERROR] 로또 번호는 중복되는 숫자가 없어야 합니다."
        const val NOT_IN_ONE_TO_FOURTY_FIVE = "[EROOR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}

