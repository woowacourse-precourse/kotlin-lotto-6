package lotto.view

import lotto.utils.Constant.LOTTO_QUANTITY_MESSAGE
import lotto.utils.Constant.PURCHASE_AMOUNT_MESSAGE

class OutputView {

    fun printAmountMessage() = println(PURCHASE_AMOUNT_MESSAGE)

    fun printLottoQuantity(quantity: Int) = println(LOTTO_QUANTITY_MESSAGE.format(quantity))

    fun printLottoNumbers(lottoNumbers: List<Lotto>) =
        lottoNumbers.forEach { lottoNumber -> println(lottoNumber.getNumbers()) }

}