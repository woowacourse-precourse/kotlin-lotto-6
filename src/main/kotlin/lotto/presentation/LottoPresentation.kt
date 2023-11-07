package lotto.presentation

import camp.nextstep.edu.missionutils.Console

class LottoPresentation {
    fun getLottoPurchaseAmountInput(): String {
        println("구입금액을 입력해 주세요.")
        val purchaseLottoInput = Console.readLine()
        return purchaseLottoInput
    }
}