package lotto

import lotto.domain.LottoMoney
import lotto.util.LottoStore

class LottoController(private val lottoView: LottoView) {
    fun run() {
        // 1단계 : 돈 지불하여 로또 구매
        val lottoMoney = payMoney() // 돈 입력
        val lottos = purchaseLottos(lottoMoney.money) // 로또 구매

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

    private fun purchaseLottos(money: Int): List<Lotto> {
        val lottoCount = money / LottoStore.LOTTO_TICKET_PRICE
        val lottos = mutableListOf<Lotto>()
        lottoView.printLottoCount(lottoCount)
        repeat(lottoCount) { lottos.add(Lotto.fromList(LottoStore().buy())) }
        lottoView.printLottos(lottos)
        return lottos
    }

}
