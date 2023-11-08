package lotto.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun buyLotto(): Int {
        val amount = Console.readLine().toInt()
        return amount
    }

    fun drawWinNumber(): MutableList<Int> {
        val winNum = Console.readLine().split(",").toMutableList()
        val winNumber = winNum.map { it.toInt() }
        return winNumber.toMutableList()
    }

    fun drawBonusNumber(): Int = Console.readLine().toInt()

    companion object {
        const val INPUT_BUY_AMOUNT = "구입금액을 입력해 주세요."
        const val INPUT_WIN_NUMBER = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    }
}


