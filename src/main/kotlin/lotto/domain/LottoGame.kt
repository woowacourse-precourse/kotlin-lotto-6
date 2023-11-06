package lotto.domain

import lotto.InputManager
import lotto.view.OutputView

class LottoGame {
    private val inputManager = InputManager()
    private val outputView = OutputView()
    private val lottoShop = LottoShop()

    fun startGame() {
        val inputMoney = inputManager.getInputMoney()
        val lottos = lottoShop.purchaseLottos(inputMoney)
        printLottos(lottos)

        val winningNumber = inputManager.getWinningNumbers()
        val winningLotto = Lotto(winningNumber)
        val bonusNumber = inputManager.getBonusNumber(winningNumber)
        val result = Result()

        for (lotto in lottos) {
            val count = lottoShop.getMatchingCount(lotto, winningLotto)
            val isBonus = lottoShop.isBonusMatch(lotto, bonusNumber)

            result.put(Rank.checkRank(count, isBonus))
        }
        outputView.printWinningResult(result)

        val totalReward = result.getTotalReward().toDouble()
        val rateOfReturn = totalReward / inputMoney * 100
        outputView.printRateOfReturn(rateOfReturn)
    }

    private fun printLottos(lottos: List<Lotto>) {
        outputView.printNumberOfLottos(lottos)
        outputView.printLottoNumbers(lottos)
    }
}