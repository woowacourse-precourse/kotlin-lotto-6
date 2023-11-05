package app

import lotto.Lotto
import lotto.LottoInitializer

fun main() {
    val lotto = LottoInitializer()
    val lottos = mutableListOf<Lotto>()

    val price = lotto.inputPriceOfLotto()
    val amountOfLotto = price/1000

    for (amount in 0 until amountOfLotto) {
        val numbers = lotto.makeLottoNumber()
        lottos.add(Lotto(numbers))
    }
    print(lottos[0].getNumbers())
}
