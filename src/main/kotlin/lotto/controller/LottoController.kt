package lotto.controller

import lotto.domain.LottoBundle
import lotto.domain.LottoManager
import lotto.domain.LottoShop
import lotto.view.InputView.getBonusNumbersInput
import lotto.view.InputView.getLottoPurchaseCostInput
import lotto.view.InputView.getWinningNumbersInput
import lotto.view.OutputView.printLottoBundleNumbers
import lotto.view.OutputView.printLottoResult

class LottoController {
    private val lottoManager: LottoManager by lazy { LottoManager() }
    private val lottoShop: LottoShop by lazy { LottoShop() }

    fun run() {
        val purchaseMoney = getLottoPurchaseCostInput()
        val lottoBundle = LottoBundle(lottoShop.purchaseLottos(purchaseMoney))
        printLottoBundleNumbers(lottobundle = lottoBundle)

        val winningNumbers = getWinningNumbersInput()
        lottoManager.setWinningNumbers(input = winningNumbers)
        println()

        val bonusNumber = getBonusNumbersInput()
        lottoManager.setBonusNumber(input = bonusNumber)
        println()

        lottoBundle.calculateTotalLottoRank(
            winningNumbers = lottoManager.winningNumbers,
            bonusNumber = lottoManager.bonusNumber!!
        )
        printLottoResult(lottoBundle)
    }

}