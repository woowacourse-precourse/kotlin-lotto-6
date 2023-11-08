package lotto.controller

import lotto.domain.LottoManager
import lotto.domain.LottoShop
import lotto.view.InputView.getBonusNumbersInput
import lotto.view.InputView.getLottoPurchaseCostInput
import lotto.view.InputView.getWinningNumbersInput
import lotto.view.OutputView.printLottosNumbers

class LottoController {
    private val lottoManager: LottoManager by lazy { LottoManager() }
    private val lottoShop: LottoShop by lazy { LottoShop() }

    fun run() {
        val purchaseMoney = getLottoPurchaseCostInput()
        val lottos = lottoShop.purchaseLottos(purchaseMoney)
        printLottosNumbers(lottos)

        val winningNumbers = getWinningNumbersInput()
        lottoManager.setWinningNumbers(winningNumbers)
        println()

        val bonusNumber = getBonusNumbersInput()
        lottoManager.setBonusNumber(bonusNumber)
        println()
    }

}