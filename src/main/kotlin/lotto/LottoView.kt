package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.util.MessageConstants

class LottoView() {

    fun printError(message: String?) = println(message)
    fun printLottoMoneyRequest() = println(MessageConstants.ENTER_LOTTO_PRICE)
    fun inputLottoMoney(): String {
        return Console.readLine()
    }

    fun printLottoCount(count: Int) = println("\n${count}${MessageConstants.PURCHASED}")
    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.toString())
        }
    }

    fun printWinningNumberRequest() = println(MessageConstants.ENTER_WINNING_NUMBER)
    fun inputWinningNumber(): String {
        return Console.readLine()
    }
}