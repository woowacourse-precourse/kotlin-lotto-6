package lotto.domain

import lotto.view.OutputManager.PURCHASED_LOTTO_AMOUNT_MSG

class LottoWallet(private val lotteries: List<Lotto>) {

    override fun toString(): String {
        var message = "\n${lotteries.size}$PURCHASED_LOTTO_AMOUNT_MSG\n"
        lotteries.forEach { lotto -> message += lotto.toString() }
        return message
    }
}