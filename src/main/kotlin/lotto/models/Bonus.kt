package lotto.models

class Bonus(private val number: Int) {

    init {
        require(isValidNumberRange()) { NUMBER_RANGE_ERROR_MESSAGE }
    }

    fun getNumber() = number

    fun checkDistinctWithWinningLotto(winningNumbers: List<Int>) {
        require(isValidDistinctNumber(winningNumbers)) { DISTINCT_NUMBER_WITH_WINNING_LOTTO_ERROR_MESSAGE }
    }

    private fun isValidNumberRange() = number in Lotto.MIN_NUMBER..Lotto.MAX_NUMBER

    private fun isValidDistinctNumber(winningNumbers: List<Int>) = number !in winningNumbers

    companion object {
        const val NUMBER_RANGE_ERROR_MESSAGE = "보너스 번호는 ${Lotto.MIN_NUMBER}에서 ${Lotto.MAX_NUMBER}사이여야 합니다."
        const val DISTINCT_NUMBER_WITH_WINNING_LOTTO_ERROR_MESSAGE = "보너스 번호가 당첨 번호와 중복됩니다."
    }
}