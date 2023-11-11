package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.*
import lotto.dto.PurchasedLottoDto
import lotto.enums.LottoRank

class PurchasedLotto {
    private var numbers : List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    private var matchingNumberCount = 0
    private var bonusBallMatched = false
    private var winPrize = 0
    private var winRank = LottoRank.NOTHING

    fun setPurchasedLotto(lottoList: List<Int>, bonusBall: Int) {
        numbers = numbers.sorted()
        countMatchingNumber(lottoList)
        if (matchingNumberCount == LOTTO_WIN_FIVE)
            checkBonusBall(bonusBall)
        setWinRankPrize()
        setWinRank()
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

    private fun setWinRankPrize() {
        when (matchingNumberCount) {
            MATCH_SIX -> winPrize = LOTTO_FIRST_WIN_COST
            MATCH_FIVE -> {
                winPrize = if (bonusBallMatched)
                    LOTTO_SECOND_WIN_COST
                else
                    LOTTO_THIRD_WIN_COST
            }
            MATCH_FOUR -> winPrize = LOTTO_FORTH_WIN_COST
            MATCH_THREE -> winPrize = LOTTO_FIFTH_WIN_COST
        }
    }

    private fun setWinRank() {
        when (matchingNumberCount) {
            MATCH_SIX -> winRank = LottoRank.FIRST
            MATCH_FIVE -> {
                winRank = if (bonusBallMatched)
                    LottoRank.SECOND
                else
                    LottoRank.THIRD
            }
            MATCH_FOUR -> winRank = LottoRank.FORTH
            MATCH_THREE -> winRank = LottoRank.FIFTH
        }
    }

    fun getWinPrize(): Int {
        return winPrize
    }

    fun getWinRank(): Int {
        return winRank.rank
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}