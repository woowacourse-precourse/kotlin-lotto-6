package lotto.model

import lotto.utils.Constants

class WinningNumbers(val winningNumbers: List<Int>) {
    private var bonusNumber: Int = Constants.BONUS_NUMBER_INIT

    init {
        checkNumbersValidate()
    }

    private fun checkNumbersValidate() {
        winningNumbers.forEach { number ->
            require(number in Lotto.lottoRange) { Constants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE }
        }
        require(winningNumbers.size == 6) { Constants.LOTTO_NUMBER_SIZE_ERROR_MESSAGE }
        require(winningNumbers.size == winningNumbers.toSet().size) { Constants.LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE }
    }

    fun setBonusNumber(bonusNumber: Int) {
        require(!winningNumbers.contains(bonusNumber)) { Constants.LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE }
        this.bonusNumber = bonusNumber
    }

    fun lottoToWinningRank(lotto: Lotto): WinningRank {
        val matchCount = lotto.getMatchCount(winningNumbers)
        val isBonusMatch = lotto.isMatchNumber(bonusNumber)
        return WinningRank.entries.firstOrNull { it.matchCount == matchCount && it.isBonusMatch == isBonusMatch }
            ?: WinningRank.NONE
    }
}