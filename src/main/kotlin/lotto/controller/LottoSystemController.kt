package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoPaper
import lotto.model.validation.InputValidation
import lotto.view.LottoSystemView

class LottoSystemController(lottoSystemView: LottoSystemView) {
    private var lottoSystemView: LottoSystemView
    private lateinit var winningLottoNum: Lotto

    init {
        this.lottoSystemView = lottoSystemView
    }

    fun run() {
        var lottoPaper = createLottoPaper()
        printLottoPaper(lottoPaper)
        inputWinningNumbers()
        inputBonusNumbers()
    }

    private fun createLottoPaper(): LottoPaper {
        var lottoLintCount: Int = inputLottoPurchaseMount()
        return createLottoLineList(lottoLintCount)
    }

    private fun inputLottoPurchaseMount(): Int {
        var inputLottoPurchaseAmount = lottoSystemView.getLottoPurchaseMount()
        return InputValidation().validateLottoPurchaseAmount(inputLottoPurchaseAmount)
    }

    private fun createLottoLineList(lottoLineCount: Int): LottoPaper {
        return LottoPaper(lottoLineCount)
    }

    private fun printLottoPaper(lottoPaper: LottoPaper) {
        lottoSystemView.printLottoNumList(lottoPaper)
    }

    private fun inputWinningNumbers() {
        var inputWinningNum = lottoSystemView.getWinningLottoNum()
        winningLottoNum = InputValidation().validateInputWinningLottoNum(inputWinningNum)
    }

    private fun inputBonusNumbers(){
        var inputBonusNum = lottoSystemView.getBonusLottoNum()
        var bonusNum = InputValidation().validateInputBonusNum(inputBonusNum)
        winningLottoNum.setBonusNum(bonusNum)
    }
}