package lotto.domain

import lotto.utils.Constant.INVALID_SIZE_EXCEPTION_MESSAGE
import lotto.utils.Constant.LOTTO_NUMBER_SIZE

private const val SIZE_SIX = 6
private const val SIZE_FIVE = 5
private const val SIZE_FOUR = 4
private const val SIZE_THREE = 3

class WinningLotto(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INVALID_SIZE_EXCEPTION_MESSAGE }
    }

    fun determineWinner(playerLotto: Lotto, bonusNumber: Int): WinningRank {
        val winningNumbers = playerLotto.filter { it in numbers }
        return when (winningNumbers.size) {
            SIZE_SIX -> WinningRank.SIX_MATCHES
            SIZE_FIVE -> isBonusNumberMatched(winningNumbers, LottoNumber(bonusNumber))
            SIZE_FOUR -> WinningRank.FOUR_MATCHES
            SIZE_THREE -> WinningRank.THREE_MATCHES
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


