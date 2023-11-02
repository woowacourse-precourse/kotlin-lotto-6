package lotto.view

import lotto.model.Lotto
import lotto.util.Constant.INPUT_LUCKY_NUMBER_MESSAGE
import lotto.util.Constant.INPUT_PRICE_MESSAGE
import lotto.util.Constant.LOTTO_BUY_MESSAGE
import lotto.util.Constant.UNIT_PRICE

class OutputView {

    fun printInputPrice() = println(INPUT_PRICE_MESSAGE)
    fun printBuyLotto(price: Int) = println("\n${LOTTO_BUY_MESSAGE.format(price / UNIT_PRICE)}")
    fun printUserLotto(lottoes: List<Lotto>) = lottoes.forEach { lotto -> println(lotto.getLottoNumbers()) }

    fun printInputLuckyNumber() = println("\n${INPUT_LUCKY_NUMBER_MESSAGE}")
}