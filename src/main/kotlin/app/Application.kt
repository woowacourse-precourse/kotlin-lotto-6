package app

import lotto.Lotto
import lotto.LottoInitializer
import kotlin.reflect.typeOf

fun main() {
    val lotto = LottoInitializer()

    val price = lotto.inputPriceOfLotto()
    val amountOfLotto = price/1000

    for(amount in 0 until amountOfLotto) {
        val numbers = lotto.makeLottoNumber()
        val userlotto = Lotto(numbers)

    }
}
