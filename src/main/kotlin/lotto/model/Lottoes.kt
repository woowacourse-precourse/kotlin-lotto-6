package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants

class Lottoes(countOfPurchasedLotto: Int) {
    val lottoes = mutableListOf<Lotto>()

    init {
        for (i in 0 until countOfPurchasedLotto) {
            lottoes.add(Lotto(makeLottoNumbers()))
        }
    }

    private fun makeLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            Constants.MIN_LOTTO_NUMBER_RANGE,
            Constants.MAX_LOTTO_NUMBER_RANGE,
            Constants.LOTTO_NUMBER_COUNT
        )
    }

    fun confirmWinningNumbers(winningNumbers: WinningNumbers): Map<WinningRank, Int> {
        val winningStatistic = HashMap<WinningRank, Int>()
        lottoes.forEach { lotto ->
            val winningRank = winningNumbers.lottoToWinningRank(lotto)
            val countByWinningRank = winningStatistic.getOrDefault(winningRank, Constants.LOTTO_MIN_COUNT)
            winningStatistic[winningRank] = countByWinningRank + Constants.LOTTO_COUNT_PLUS_UNIT
        }
        return winningStatistic
    }
}