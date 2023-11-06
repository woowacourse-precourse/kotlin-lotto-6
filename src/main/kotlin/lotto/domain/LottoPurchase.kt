package lotto.domain

import lotto.constants.*
import lotto.ui.Input

class LottoPurchase {
    init {
        println(MESSAGE_PURCHASE_AMOUNT)
    }

    fun inputAmount(): Int {
        val amount = Input.inputPurchaseAmount()
        validateAmount(amount)
        return amount.toInt() / AMOUNT_UNIT
    }

    fun validateAmount(amount: String) {
        for (c in amount) {
            if (c !in MINIMUM_NUMBER until MAXIMUM_NUMBER) throw IllegalArgumentException(
                MESSAGE_ONLY_NUMBER
            )
        }
        if (amount.toInt() % AMOUNT_UNIT != 0) throw IllegalArgumentException(
            MESSAGE_NOT_FIT_UNIT_1000
        )
    }

    fun buyLottos(lotteryNumber: Int): MutableList<Lotto> {
        val lottos = mutableListOf<Lotto>()
        val lottoGenerator = LottoGenerator()
        repeat(lotteryNumber){
            val lotto = lottoGenerator.generatorLotto()
            lottos.add(lotto)
        }
        return lottos
    }
}