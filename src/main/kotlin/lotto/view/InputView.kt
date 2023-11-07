package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {


    fun inputView(): String = Console.readLine()

    fun buyMessage() {
        println(PURCHASE_MESSAGE)
    }

    fun lottoMessage() {
        println(LOTTO_NUM_MESSAGE)
    }

    companion object {
        const val PURCHASE_MESSAGE = "구입금액을 입력해 주세요."
        const val LOTTO_NUM_MESSAGE = "당첨 번호를 입력해 주세요."
        const val BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요."
    }
}