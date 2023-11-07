package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputPurchaseAmount(): Int {
        val purchaseAmount = Console.readLine()
        return purchaseAmount.toInt()
    }

    fun inputPrizeLottoNumber(): List<Int> {
        val prizeLottoNumber = Console.readLine()
        val prizeLottoNumberList = prizeLottoNumber.split(",")
        return prizeLottoNumberList.map { it.toInt() }
    }

    fun inputPrizeBonusNumber(): Int {
        val bonusNumber = Console.readLine()
        return bonusNumber.toInt()
    }
}