package app

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.LottoInitializer
import lotto.UserInterface

fun main() {
    val lotto = LottoInitializer()

    println(UserInterface.INPUT_USER_PURCHASE_AMOUNT.mention)

    var price = Console.readLine().toInt()
    var amountOfLotto = lotto.dividePriceByThousand(price)
    for(amount in 0 until amountOfLotto) {
        val numbers = lotto.makeLottoNumber()
        val userlotto = Lotto(numbers)
    }
}
