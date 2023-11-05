package app

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.LottoInitializer
import UI.UserInterface

fun main() {
    val lotto = LottoInitializer()



    val price = lotto.inputPriceOfLotto()
    val amountOfLotto = price/1000

    for(amount in 0 until amountOfLotto) {
        val numbers = lotto.makeLottoNumber()
        val userlotto = Lotto(numbers)
    }
}
