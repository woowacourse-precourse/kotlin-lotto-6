package lotto

private const val CNT_LOTTO_NUMBER = 6
private const val MIN_LOTTO_NUMBER = 1
private const val MAX_LOTTO_NUMBER = 45

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == CNT_LOTTO_NUMBER)
        require(numbers.toSet().size == CNT_LOTTO_NUMBER)
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER })
    }

    fun checkMatch(winningNumbers: List<Int>, bonusNumber: Int): LottoRank? {
        val matchingNumbers = numbers.intersect(winningNumbers.toSet())
        return when (matchingNumbers.size) {
            6 -> LottoRank.FIRST
            5 -> if (numbers.contains(bonusNumber)) LottoRank.SECOND else LottoRank.THIRD
            4 -> LottoRank.FOURTH
            3 -> LottoRank.FIFTH
            else -> null
        }

    }

    fun returnLottoNumbers(): List<Int> {
        return numbers
    }

}
