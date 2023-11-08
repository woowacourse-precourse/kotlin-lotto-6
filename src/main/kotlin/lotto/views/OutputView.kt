package lotto.views

import lotto.LottoGame
import lotto.models.Lotto

class OutputView {

    fun printPurchasedLottoCount(lottoCount: Int) = println(PURCHASED_LOTTO_COUNT_MESSAGE.format(lottoCount))

    fun printPurchasedLottos(purchasedLottos: List<Lotto>) {
        purchasedLottos.forEach {
            val formattedLottoNumbers = formatLottoNumbers(it)
            println(PURCHASED_LOTTO_NUMBERS_MESSAGE.format(formattedLottoNumbers))
        }
    }

    private fun formatLottoNumbers(lotto: Lotto): String = lotto.getNumbers().joinToString(LOTTO_NUMBER_SEPARATOR)

    companion object {
        const val PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다."
        const val PURCHASED_LOTTO_NUMBERS_MESSAGE = "[%s]"

        const val LOTTO_NUMBER_SEPARATOR = ", "
    }
}