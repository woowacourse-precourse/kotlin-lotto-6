package lotto.domain.lotto

import lotto.domain.WinningLotto
import lotto.view.OutputManager.PURCHASED_LOTTO_AMOUNT_MSG

class LottoWallet(private val lotteries: List<Lotto>) {
    val lottoCount = lotteries.size

    fun compareWithWinningLotto(winningLotto: WinningLotto): List<LottoResult> =
        lotteries.map { lotto ->
            winningLotto.checkWinning(lotto)
        }

    override fun toString(): String {
        var message = "\n${lotteries.size}$PURCHASED_LOTTO_AMOUNT_MSG\n"
        lotteries.forEach { lotto -> message += lotto.toString() }
        return message
    }
}