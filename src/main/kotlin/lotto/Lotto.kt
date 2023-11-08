package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoNumber.LOTTO_NUMBER_COUNT.number) { ErrorMessage.LOTTO_NUMBER_COUNT.message }
        require(numbers.toSet().size == LottoNumber.LOTTO_NUMBER_COUNT.number) { ErrorMessage.SAME_NUMBER.message }
        require(numbers.all { it in LottoNumber.MIN_LOTTO_NUMBER.number..LottoNumber.MAX_LOTTO_NUMBER.number }) { ErrorMessage.NUMBER_RANGE.message}
    }

    override fun toString(): String = numbers.joinToString(", ", "[", "]")

    fun countMatchingNumbers(winningNumbers: List<Int>): Int = numbers.count { winningNumbers.contains(it) }

    fun hasBonusNumber(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)
}
