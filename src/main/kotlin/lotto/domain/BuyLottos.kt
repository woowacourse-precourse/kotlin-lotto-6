package lotto.domain

import lotto.Lotto
import camp.nextstep.edu.missionutils.Randoms
import lotto.view.OutputView

class BuyLottos {
    private val outputView = OutputView()

    fun buyLottos(buyAmount: Int) : List<Lotto> {
        outputView.printBuyLottoNumber(buyAmount)

        val buyLottos = mutableListOf<Lotto>()
        for (lottoCount in LOTTO_COUNT_START..buyAmount)
            buyLottos.add(makeLotto())
        return buyLottos
    }

    private fun makeLotto() : Lotto
        = Lotto(generateLottoNumbers())

    private fun generateLottoNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(RANDOM_START_RANGE_NUMBER, RANDOM_END_RANGE_NUMBER, LOTTO_NUMBER_COUNT)

    companion object {
        const val LOTTO_COUNT_START = 1
        const val RANDOM_START_RANGE_NUMBER = 1
        const val RANDOM_END_RANGE_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6
    }
}