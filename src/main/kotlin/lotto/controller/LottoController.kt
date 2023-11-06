package lotto.controller

import LottoView
import camp.nextstep.edu.missionutils.Console

class LottoController {
    fun start() {
        LottoView.printPurchaseAmountOfLotto()
        val purchaseAmount = Console.readLine()
    }
}