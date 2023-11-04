package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    //TODO("프로그램 구현")
    val lottoNumber = LottoNumbersInitializer()

    println(UserInterface.INPUT_USER_PURCHASE_AMOUNT.mention)

    var lottoAmount = Console.readLine().toInt()
    for(amount in 0 until lottoAmount) {
        val numbers = lottoNumber.makeLottoNumber()
        val userlotto = Lotto(numbers)
    }
}
