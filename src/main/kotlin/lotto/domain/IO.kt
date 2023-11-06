package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.data.Lotto

class IO(private val validator: Validator) {

    private fun getInput() = Console.readLine()

    fun show(content: String, lineBreak: Boolean) {
        print(content)

        if (lineBreak) {
            println()
        }
    }

    fun getPurchaseAmount(): UInt {
        show(INPUT_PURCHASE_AMOUNT, true)

        val input = getInput()
        require(validator.checkInputOfPurchasingCorrect(input)) {
            SHOULD_BE_POSITIVE_NUM
        }

        return input.toUInt()
    }

    fun showIssuedLotto(tickets: List<Lotto>) {
        show(ISSUED_N_TICKET.format(tickets.size), true)
        show(tickets.joinToString(LINE_BREAK), true)
        show(EMPTY_TEXT_FOR_LINE_BREAK, true)
    }

    companion object {
        private const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        private const val ISSUED_N_TICKET = "%d개를 구매했습니다."
        private const val SHOULD_BE_POSITIVE_NUM = "[ERROR] 0보다 큰 숫자를 입력해주세요."
        private const val LINE_BREAK = "\n"
        private const val EMPTY_TEXT_FOR_LINE_BREAK = ""
    }
}