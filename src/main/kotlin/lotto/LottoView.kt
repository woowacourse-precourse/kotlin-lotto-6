package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.util.MessageConstants

class LottoView() {

    fun printError(message: String?) = println(message)
    fun printLottoMoneyRequest() = println(MessageConstants.ENTER_LOTTO_PRICE)
    fun inputLottoMoney(): String {
        return Console.readLine()
    }
}