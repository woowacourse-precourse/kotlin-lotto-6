package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        private const val WIN_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요."
        private const val BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."
        private const val PURCHASE_PRICE_PROMPT = "구입금액을 입력해 주세요."

        fun promptForPurchasePrice(): String {
            println(PURCHASE_PRICE_PROMPT)
            return Console.readLine().replace(" ", "")
        }

        fun promptForWinNumbers(): List<String> {
            println(WIN_NUMBERS_PROMPT)
            val input = Console.readLine().replace(" ", "")
            return input.split(",")
        }

        fun promptForBonusNumber(): String {
            println(BONUS_NUMBER_PROMPT)
            return Console.readLine().replace(" ", "")
        }
    }
}
