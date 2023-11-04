package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputPurchaseAmount(): Int {
        val purchaseAmount = Console.readLine()
        //Exception
        //outOfInt, not a number
        //금액이 숫자가 아닌 경우, 범위를 초과하는 경우 예외처리, under 1000

        return purchaseAmount.toInt()
    }

    fun inputWinningNumberList() : List<Int> {
        val winningNumberList = readln().split(',').map { it.toInt() }
        //예외처리
        return winningNumberList
    }

    fun inputBonusNumber() : Int {
        val bonusNumber = readln().toInt()
        //예외처리
        return bonusNumber
    }
}