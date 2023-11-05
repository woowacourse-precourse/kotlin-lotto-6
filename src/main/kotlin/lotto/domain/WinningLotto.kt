package lotto.domain

import lotto.utils.Constant.INVALID_SIZE_EXCEPTION_MESSAGE
import lotto.utils.Constant.LOTTO_NUMBER_SIZE

class WinningLotto(private val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INVALID_SIZE_EXCEPTION_MESSAGE }
    }

    fun determineWinner(playerLotto: Lotto, bonusNumber: Int): WinningRank {
        val winningNumbers = playerLotto.filter { it in numbers }
        return when (winningNumbers.size) {
            6 -> WinningRank.SIX_MATCHES
            5 -> isBonusNumberMatched(winningNumbers, LottoNumber(bonusNumber))
            4 -> WinningRank.FOUR_MATCHES
            3 -> WinningRank.THREE_MATCHES
            else -> WinningRank.NO_MATCHES
        }
    }

    private fun isBonusNumberMatched(lotto: List<LottoNumber>, bonusNumber: LottoNumber): WinningRank {
        if (lotto.contains(bonusNumber)) {
            return WinningRank.FIVE_MATCHES_WITH_BONUS_NUMBER
        }
        return WinningRank.FIVE_MATCHES
    }

}


