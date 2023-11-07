package lotto

import lotto.domain.LottoMoney

class LottoController(private val lottoView: LottoView) {
    fun run() {
        // 1단계 : 돈 지불하여 로또 구매
        val lottoMoney = payMoney() // 돈 입력
    }


    // 입력 실패시 재시도
    private fun payMoney(): LottoMoney {
        return try {
            lottoView.printLottoMoneyRequest()
            LottoMoney.from(lottoView.inputLottoMoney())
        } catch (e: IllegalArgumentException) {
            lottoView.printError(e.message)
            return payMoney()
        }
    }
}
