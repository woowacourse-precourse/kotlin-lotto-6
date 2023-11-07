package lotto

import lotto.domain.LottoMoney
import lotto.util.ErrorConstants
import lotto.util.LottoStore
import lotto.util.parseInt
import lotto.util.validateRange

class LottoController(private val lottoView: LottoView) {
    fun run() {
        // 1단계 : 돈 지불하여 로또 구매
        val lottoMoney = payMoney() // 돈 입력
        val lottos = purchaseLottos(lottoMoney.money) // 로또 구매
        // 2단계 : 로또 당첨 번호 추첨
        val lottoResult = processLottoWinningNumbers()
        // 3단계 : 로또 보너스 번호 추첨
        val bonus = processLottoBonusNumber(lottoResult)
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

    private fun processLottoWinningNumbers(): Lotto {
        return try {
            lottoView.printWinningNumberRequest()
            Lotto.fromInput(lottoView.inputWinningNumber())
        } catch (e: IllegalArgumentException) {
            lottoView.printError(e.message)
            return processLottoWinningNumbers()
        }
    }

    private fun processLottoBonusNumber(lotto: Lotto): Int {
        return try {
            lottoView.printBonusNumberRequest()
            val input = lottoView.inputBonusNumber()
                    .parseInt()
                    .validateRange(LottoStore.LOTTO_MIN_NUMBER, LottoStore.LOTTO_MAX_NUMBER)

            if (lotto.contains(input)) throw IllegalArgumentException(ErrorConstants.NOT_UNIQUE)
            input
        } catch (e: IllegalArgumentException) {
            lottoView.printError(e.message)
            return processLottoBonusNumber(lotto)
        }
    }

}
