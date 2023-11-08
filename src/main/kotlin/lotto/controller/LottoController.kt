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
        val lottoBundle = purchaseLottos()

        setLotteryNumbers()

        lottoBundle.calculateTotalLottoRank(
            winningNumbers = lottoManager.winningNumbers,
            bonusNumber = lottoManager.bonusNumber!!
        )

        printLottoResult(lottoBundle = lottoBundle)
    }

    fun purchaseLottos(): LottoBundle {
        return try {
            val purchaseMoney = getLottoPurchaseCostInput()
            val lottoBundle = LottoBundle(lottoShop.purchaseLottos(purchaseMoney))
            printLottoBundleNumbers(lottoBundle = lottoBundle)

            lottoBundle
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            purchaseLottos()
        }
    }

    fun setLotteryNumbers() {
        setWinningNumbers()
        setBonusNumber()
    }

    fun setWinningNumbers() {
        try {
            val winningNumbers = getWinningNumbersInput()
            lottoManager.setWinningNumbers(input = winningNumbers)
            println()
        } catch (exception: IllegalArgumentException) {
            setWinningNumbers()
        }
    }

    fun setBonusNumber() {
        try {
            val bonusNumber = getBonusNumbersInput()
            lottoManager.setBonusNumber(input = bonusNumber)
            println()
        } catch (exception: IllegalArgumentException) {
            setBonusNumber()
        }
    }
}