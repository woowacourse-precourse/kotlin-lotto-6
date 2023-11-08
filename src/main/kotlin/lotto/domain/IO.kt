package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.data.Lotto
import lotto.data.Stats

class IO private constructor() {

    fun getPurchaseAmount(): UInt {
        show(INPUT_AMOUNT_OF_PURCHASING, true)

        val input = getInput()
        require(Validator.getInstance().checkInputIsPositiveNum(input)) {
            SHOULD_BE_POSITIVE_NUM
        }
        return input.toUInt()
    }

    fun showIssuedLotto(tickets: List<Lotto>) {
        show(EMPTY_TEXT_FOR_LINE_BREAK, true)
        show(ISSUED_N_TICKET.format(tickets.size), true)
        show(tickets.joinToString(LINE_BREAK), true)
    }

    fun getWinningLottoNum(): List<Int> {
        show(EMPTY_TEXT_FOR_LINE_BREAK, true)
        show(INPUT_WINNING_NUM, true)

        val input = getInput()
        require(Validator.getInstance().checkInputIsConsistOfPositiveNum(input)) {
            LOTTO_INPUT_FORM_SHOULD_BE_KEPT
        }
        val nums = input.split(INPUT_SPLITTER).map { it.toInt() }
        Validator.getInstance().checkLottoNumberIsCorrect(nums)

        return nums
    }

    fun getBonusNum(lottoNums: List<Int>): Int {
        show(EMPTY_TEXT_FOR_LINE_BREAK, true)
        show(INPUT_BONUS_NUM, true)

        val input = getInput()
        Validator.getInstance().checkInputOfBonusCorrect(input, lottoNums)
        return input.toInt()
    }

    fun showStats(stats: Stats) {
        show(EMPTY_TEXT_FOR_LINE_BREAK, true)
        show(stats.toString(), false)
    }

    private fun show(content: String, lineBreak: Boolean) {
        print(content)

        if (lineBreak) {
            println()
        }
    }

    private fun getInput() = Console.readLine()

    companion object {
        const val INPUT_SPLITTER = ","
        private const val INPUT_AMOUNT_OF_PURCHASING = "구입금액을 입력해 주세요."
        private const val ISSUED_N_TICKET = "%d개를 구매했습니다."
        private const val INPUT_WINNING_NUM = "당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요."
        private const val SHOULD_BE_POSITIVE_NUM = "[ERROR] 0보다 큰 숫자를 입력해주세요."
        private const val LOTTO_INPUT_FORM_SHOULD_BE_KEPT = "[ERROR] 번호는 쉼표(,)를 기준으로 입력하세요. ex) 1,2,3,4,5,6"
        private const val LINE_BREAK = "\n"
        private const val EMPTY_TEXT_FOR_LINE_BREAK = ""

        @Volatile
        private var instance: IO? = null
        fun getInstance(): IO {
            val currentInstance = instance
            if (currentInstance != null) {
                return currentInstance
            }
            return synchronized(this) {
                val synchronizedInstance = instance
                if (synchronizedInstance != null) {
                    return@synchronized synchronizedInstance
                }
                val createdIO = IO()
                instance = createdIO
                createdIO
            }
        }
    }
}