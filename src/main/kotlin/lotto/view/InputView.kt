package lotto.view

import camp.nextstep.edu.missionutils.Console
class InputView {

    fun promptPurchaseAmount(): String {
        println(INPUT_PURCHASE_AMOUNT)
        return Console.readLine()
    }
    companion object{
        const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUM = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요."
    }
}