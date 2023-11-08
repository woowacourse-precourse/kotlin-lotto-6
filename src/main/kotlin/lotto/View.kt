package lotto

import camp.nextstep.edu.missionutils.Console

class View {

    fun inputPayment(): Payment {
        while (true) {
            println(INPUT_PAYMENT_MESSAGE)
            val input = Console.readLine()
            try {
                return Payment(input)
            } catch (e: IllegalArgumentException) {
                printErrorMessage(e)
                continue
            }
        }
    }

    fun inputLottoNumber(): Lotto {
        while (true) {
            println(INPUT_LOTTO_NUMBER_MESSAGE)
            val input = Console.readLine()
            val number = input.split(",").sorted()
            try {
                return Lotto(number.map { it.toInt() })
            } catch (e: IllegalArgumentException) {
                printErrorMessage(e)
                continue
            }
        }
    }

    fun inputBonusLottoNumber(inputLottoNumber: Lotto): BonusNumber {
        while (true) {
            println(INPUT_BONUS_NUMBER_MESSAGE)
            val input = Console.readLine()
            try {
                return BonusNumber(input, inputLottoNumber)
            } catch (e: IllegalArgumentException) {
                printErrorMessage(e)
                continue
            }
        }
    }

    private fun printErrorMessage(e: IllegalArgumentException) {
        println("${e.message}\n")
    }

    fun printLotto(lotto: List<Lotto>) {
        println(PRINT_LOTTO_MESSAGE.format(lotto.size))
        lotto.forEach {
            println(it.getLottoNumbers())
        }
    }

    fun printPrizeResult(prize: Prize) {
        println(PRINT_PRIZE_RESULT_MESSAGE)
        println(FIFTH_PRIZE_RESULT.format(prize.fifth))
        println(FORTH_PRIZE_RESULT.format(prize.fourth))
        println(THIRD_PRIZE_RESULT.format(prize.third))
        println(SECOND_PRIZE_RESULT.format(prize.second))
        println(FIRST_PRIZE_RESULT.format(prize.first))
    }

    fun printWinRate(winRate: Double) {
        println(EARNINGS_RATE_MESSAGE.format(winRate))
    }

    companion object {
        const val INPUT_PAYMENT_MESSAGE = "구입금액을 입력해 주세요."
        const val INPUT_LOTTO_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요."
        const val PRINT_LOTTO_MESSAGE = "\n%d개를 구매했습니다."
        const val PRINT_PRIZE_RESULT_MESSAGE = "\n당첨 통계\n---"
        const val FIFTH_PRIZE_RESULT = "3개 일치 (5,000원) - %d개"
        const val FORTH_PRIZE_RESULT = "4개 일치 (50,000원) - %d개"
        const val THIRD_PRIZE_RESULT = "5개 일치 (1,500,000원) - %d개"
        const val SECOND_PRIZE_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val FIRST_PRIZE_RESULT = "6개 일치 (2,000,000,000원) - %d개"
        const val EARNINGS_RATE_MESSAGE  = "총 수익률은 %.1f%%입니다."
    }
}
