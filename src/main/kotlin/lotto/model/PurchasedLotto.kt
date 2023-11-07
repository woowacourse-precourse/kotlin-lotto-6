package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.*

class PurchasedLotto(lottoList: List<Int>, bonusBall: Int) {
    private var numbers : List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    private var matchingNumberCount = 0
    private var bonusBallMatched = false
    private var winPrize = 0

    init {
        numbers = numbers.sorted()
        countMatchingNumber(lottoList)
        if (matchingNumberCount == LOTTO_WIN_FIVE)
            checkBonusBall(bonusBall)
        getWinRankCost()
    }

    private fun countMatchingNumber(lottoList: List<Int>) {
        for (i in lottoList) {
            if (numbers.contains(i)) {
                matchingNumberCount += 1
            }
        }
    }

    private fun checkBonusBall(bonusBall: Int) {
        if (numbers.contains(bonusBall))
            bonusBallMatched = true
    }

    private fun getWinRankCost() {
        when (matchingNumberCount) {
            WIN_RANK_FIRST -> winPrize = LOTTO_FIRST_WIN_COST
            WIN_RANK_SECOND_AND_THIRD -> {
                if (bonusBallMatched)
                    winPrize = LOTTO_SECOND_WIN_COST
                winPrize = LOTTO_THIRD_WIN_COST
            }
            WIN_RANK_FORTH -> winPrize = LOTTO_FORTH_WIN_COST
            WIN_RANK_FIFTH -> winPrize = LOTTO_FIFTH_WIN_COST
        }
    }

    fun getWinPrize(): Int {
        return winPrize
    }
}