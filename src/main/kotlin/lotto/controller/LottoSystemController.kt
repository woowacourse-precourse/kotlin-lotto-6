package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoMatchNum
import lotto.model.LottoPaper
import lotto.model.LottoResult
import lotto.model.validation.InputValidation
import lotto.util.inputHandler
import lotto.view.LottoSystemView

class LottoSystemController(lottoSystemView: LottoSystemView) {
    private var lottoSystemView: LottoSystemView
    private var lottoPurchaseMount: Int = 0
    private lateinit var winningLottoNum: Lotto
    private var bonusNum: Int = 0
    var lottoResult = LottoResult()

    init {
        this.lottoSystemView = lottoSystemView
    }

    fun run() {
        var lottoPaper = createLottoPaper()
        printLottoPaper(lottoPaper)
        inputWinningNumbers()
        inputBonusNumbers()
        checkDuplicateLottoNumbers(lottoPaper)
        printTotalWinningResult(lottoResult)
    }

    private fun createLottoPaper(): LottoPaper {
        lottoPurchaseMount = inputLottoPurchaseMount()
        return createLottoLineList(lottoPurchaseMount / 1000)
    }

    private fun inputLottoPurchaseMount(): Int {
        lottoSystemView.printLottoPurchaseMountMessage()
        while (true) {
            try {
                val inputLottoPurchaseAmount = inputHandler()
                return InputValidation().validateLottoPurchaseAmount(inputLottoPurchaseAmount)
            } catch (e: IllegalArgumentException) {
                println("${e.message} 다시 입력하세요.")
            }
        }
    }

    private fun createLottoLineList(lottoLineCount: Int): LottoPaper {
        return LottoPaper(lottoLineCount)
    }

    private fun printLottoPaper(lottoPaper: LottoPaper) {
        lottoSystemView.printLottoNumList(lottoPaper)
    }

    private fun inputWinningNumbers() {
        lottoSystemView.printWinningLottoNumMessage()
        while (true) {
            try {
                var inputWinningNum = inputHandler()
                winningLottoNum = InputValidation().validateInputWinningLottoNum(inputWinningNum)
                return
            } catch (e: IllegalArgumentException) {
                println("${e.message} 다시 입력하세요.")
            }
        }
    }

    private fun inputBonusNumbers() {
        lottoSystemView.printBonusLottoNumMessage()
        while (true) {
            try {
                var inputBonusNum = inputHandler()
                bonusNum = InputValidation().validateInputBonusNum(inputBonusNum)
                return
            } catch (e: IllegalArgumentException) {
                println("${e.message} 다시 입력하세요.")
            }
        }
    }

    private fun checkDuplicateLottoNumbers(lottoPaper: LottoPaper) {
        lottoPaper.getLottoPaper().forEach { lotto ->
            var duplicatedNumCount = lotto.getLottoNumbers().size - (lotto.getLottoNumbers()
                .filterNot { it in winningLottoNum.getLottoNumbers() }.size)
            if (duplicatedNumCount == 5) {
                checkDuplicateBonusNumber(lotto)
            }
            lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(duplicatedNumCount))
        }
    }

    private fun checkDuplicateBonusNumber(lotto: Lotto) {
        if (bonusNum in lotto.getLottoNumbers()) {
            lottoResult.setMatchingLottoResult(LottoMatchNum.fromValue(LottoMatchNum.FIVE_PLUS_BONUS.matchingNum))
        }
    }

    private fun printTotalWinningResult(lottoResult: LottoResult) {
        lottoSystemView.printWinningStatistics(lottoResult)
        lottoResult.calculateTotalLottoPrize()
        lottoResult.calculateLottoReturnOfRate(lottoPurchaseMount)
        lottoSystemView.printRateOfReturn(lottoResult.getTotalLottoRateOfReturn())
    }
}