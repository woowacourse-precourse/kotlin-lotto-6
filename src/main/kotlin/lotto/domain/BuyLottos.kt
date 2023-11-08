package lotto.domain

import lotto.Lotto
import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto.Companion.LOTTO_NUMBER_COUNT
import lotto.Lotto.Companion.LOTTO_RANDOM_END_NUMBER
import lotto.Lotto.Companion.LOTTO_RANDOM_START_NUMBER
import lotto.view.OutputView

class BuyLottos {
    private val outputView = OutputView()

    fun buyLottos(buyAmount: Int): List<Lotto> {
        outputView.printBuyLottoNumber(buyAmount)

        val buyLottos = mutableListOf<Lotto>()
        for (lottoCount in LOTTO_COUNT_START..buyAmount)
            buyLottos.add(makeLotto())
        return buyLottos
    }

    private fun makeLotto(): Lotto = Lotto(generateLottoNumbers())

    private fun generateLottoNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(LOTTO_RANDOM_START_NUMBER, LOTTO_RANDOM_END_NUMBER, LOTTO_NUMBER_COUNT)

    companion object {
        const val LOTTO_COUNT_START = 1
    }
}