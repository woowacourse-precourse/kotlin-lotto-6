package lotto.view

import camp.nextstep.edu.missionutils.Console


class UserInput {

    fun getPurchaseAmount(): String {
        println(PURCHASE_LOTTO_MESSAGE)
        return Console.readLine().also { println() }
    }

    fun getAnswerNumber(): String {
        println(ANSWER_NUM_MESSAGE)
        return Console.readLine().also { println() }
    }

    fun getBonusNum(): String {
        println(BONUS_NUM_MESSAGE)
        return Console.readLine().also { println() }
    }

    companion object {
        const val PURCHASE_LOTTO_MESSAGE = "구입금액을 입력해 주세요."
        const val ANSWER_NUM_MESSAGE = "당첨 번호를 입력해 주세요."
        const val BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요."
    }
}