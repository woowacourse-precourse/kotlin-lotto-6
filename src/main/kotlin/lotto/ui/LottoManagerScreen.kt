package lotto.ui

import lotto.data.LottoResult
import lotto.domain.LottoInputManager
import lotto.domain.LottoOutputManager

class LottoManagerScreen(lottoResult: LottoResult, lottoRevenue : Float) {

    private var lottoResult : LottoResult = LottoResult()
    private var revenue  : Float = 0.0F

    init {
        this.lottoResult = lottoResult
        this.revenue = lottoRevenue
    }

    fun printLottoResult() {
        println("당첨 통계")
        println("---")

    }


}