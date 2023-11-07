package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoPaper
import lotto.view.LottoSystemView

class LottoSystemController(lottoSystemView: LottoSystemView) {
    private var lottoSystemView: LottoSystemView

    init {
        this.lottoSystemView = lottoSystemView
    }

    fun run() {

    }

    private fun inputLottoPurchaseMount() {
        lottoSystemView.getLottoPurchaseMount()
    }

    private fun createLottoPaper(lottoLineCount: Int): LottoPaper {
        return LottoPaper(lottoLineCount)
    }

    private fun inputWinningNumbers() {
        lottoSystemView.getWinningLottoNum()
    }

    private fun inputBonusNumbers() {
        lottoSystemView.getBonusLottoNum()
    }
}