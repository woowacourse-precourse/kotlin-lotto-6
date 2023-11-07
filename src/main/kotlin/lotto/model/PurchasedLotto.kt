package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.LOTTO_WIN_FIVE

class PurchasedLotto(lottoList: List<Int>, bonusBall: Int) {
    private var numbers : List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    private var matchingNumberCount = 0
    private var bonusBallMatched = false

    init {
        numbers = numbers.sorted()
        countMatchingNumber(lottoList)
        if (matchingNumberCount == LOTTO_WIN_FIVE)
            checkBonusBall(bonusBall)
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
}