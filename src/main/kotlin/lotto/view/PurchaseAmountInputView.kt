package lotto.view

import camp.nextstep.edu.missionutils.Console

class PurchaseAmountInputView {
    var price = ""
        private set

    fun input() {
        println("구입금액을 입력해 주세요.")
        price = Console.readLine().trim()
        println()
    }
}
