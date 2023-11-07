package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readInputMoneyFromUser(): String {
        println(INPUT_MONEY_PROMPT_MESSAGE)
        return Console.readLine().trim()
    }

    fun readWinningNumbersFromUser(): String {
        println(WINNING_NUMBERS_PROMPT_MESSAGE)
        return Console.readLine()
    }

    fun readBonusNumberFromUser(): String {
        println("\n" + BONUS_NUMBER_PROMPT_MESSAGE)
        return Console.readLine().trim()
    }

    companion object {
        private const val INPUT_MONEY_PROMPT_MESSAGE = "구입금액을 입력해 주세요."
        private const val WINNING_NUMBERS_PROMPT_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val BONUS_NUMBER_PROMPT_MESSAGE = "보너스 번호를 입력해 주세요."
    }
}