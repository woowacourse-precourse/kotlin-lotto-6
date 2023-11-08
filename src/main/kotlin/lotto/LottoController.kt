package lotto

class LottoController {

    private val lottoView = LottoView()
    private val lottoModel = LottoModel()

    companion object {
        private const val ERROR = "[ERROR]"
    }

    fun start() {
        val lottos = purchaseLottos()
        val result = matchLottos(lottos)

        lottoView.showResult(result, lottos.size * LottoModel.LOTTO_PRICE)
    }

    private fun purchaseLottos(): List<Lotto> {
        val lottoPrice = lottoView.priceInput()
        val lottos = lottoModel.buyLotto(lottoPrice)
        lottoView.printLottos(lottos)
        return lottos
    }

    private fun matchLottos(lottos: List<Lotto>): Map<Rank, Int> {
        val myWinningNumber = lottoView.inputWinningNumbers()
        while (true) {
            try {
                val myBonusNumber = lottoView.inputBonusNumber()

                if (myBonusNumber in myWinningNumber) {
                    throw IllegalArgumentException()
                }
                return lottoModel.calculateResult(lottos, myWinningNumber, myBonusNumber)
            } catch (e: IllegalArgumentException) {
                println("$ERROR 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
            }

        }
    }
}