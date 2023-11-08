package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.LottoFactory
import lotto.model.WinningCounts
import lotto.view.ConsoleView

class LottoGameController(private val view: ConsoleView) {
    fun startGame() {
        val purchaseAmount = view.promptPurchaseAmount()

        val lottoQuantity = purchaseAmount / 1000
        println("${lottoQuantity}개를 구매했습니다.")

        val lottos = createLottos(lottoQuantity)
        view.displayLottos(lottos)

        val winningNum = view.promptWinningNumber()
        val bonusNum = view.promptBonusNumber()

        val result = calculateWinningCounts(lottos, winningNum, bonusNum)
        view.displayResult(result)

        calculateProfitRate(result, purchaseAmount)
    }

    private fun calculateWinningCounts(lottos: List<Lotto>, winningNum: List<Int>, bonusNum: Int): WinningCounts {
        val matchingCounts = WinningCounts()

        for (lotto in lottos) {
            val matchedNumbers = lotto.getLotto().intersect(winningNum).toList()
            val bonusNumberMatched = lotto.getLotto().contains(bonusNum)

            when (matchedNumbers.size) {
                MatchingCount.THREE.value -> matchingCounts.threeMatching++
                MatchingCount.FOUR.value -> matchingCounts.fourMatching++
                MatchingCount.FIVE.value -> {
                    if (bonusNumberMatched) {
                        matchingCounts.fivePlusBonusMatching++
                    } else {
                        matchingCounts.fiveMatching++
                    }
                }
                MatchingCount.SIX.value -> matchingCounts.sixMatching++
            }
        }
        return matchingCounts
    }

    private fun calculateProfitRate(result: WinningCounts, purchaseAmount: Int) {
        var profit = (result.threeMatching * 5000 + result.fourMatching * 50000 +
                result.fiveMatching * 1500000 + result.fivePlusBonusMatching * 30000000 +
                result.sixMatching * 2000000000).toDouble()

        val profitRate = profit / purchaseAmount * 100
        view.displayProfitRate(profitRate)
    }
}

enum class MatchingCount(val value: Int) {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6)
}

fun createLottos(lottoQuantity: Int): List<Lotto> {
    val lottos = mutableListOf<Lotto>()
    for (i in 1..lottoQuantity) {
        val lotto = LottoFactory.createLotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        lottos.add(lotto)
    }
    return lottos
}
