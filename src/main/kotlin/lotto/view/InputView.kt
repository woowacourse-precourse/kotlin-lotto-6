package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun InputBuyPriceMessage(): Int {
        return Console.readLine().toInt()
    }
}