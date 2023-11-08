package lotto

import java.text.DecimalFormat

class OutputManager {
    fun printLottoNum(lottosNum: Int) {
        println()
        println(PRINT_LOTTO_COUNT.format(lottosNum))
    }

    fun printLottos(lottoNumber: List<Int>) {
        println("${lottoNumber.sorted()}")
    }

    fun printLottoStatistic(
        firstPlace: Int,
        secondPlace: Int,
        thirdPlace: Int,
        fourthPlace: Int,
        fifthPlace: Int
    ) {
        println(LOTTO_STATISTIC)
        println(HORIZONTAL_BAR)
        println(PRINT_FIFTH_COUNT.format(fifthPlace))
        println(PRINT_FOURTH_COUNT.format(fourthPlace))
        println(PRINT_THIRD_COUNT.format(thirdPlace))
        println(PRINT_SECOND_COUNT.format(secondPlace))
        println(PRINT_FIRST_COUNT.format(firstPlace))
    }

    fun printRate(rate: Double) {
        val decimalFormat = DecimalFormat("#,##0.0")
        val profitMargin = decimalFormat.format(rate * RATE_PERCENT)

        println("총 수익률은 ${profitMargin}%입니다.")
    }

    companion object {
        const val PRINT_LOTTO_COUNT = "%d개를 구매했습니다."
        const val LOTTO_STATISTIC = "당첨 통계"
        const val HORIZONTAL_BAR = "---"
        const val PRINT_FIFTH_COUNT = "3개 일치 (5,000원) - %d개"
        const val PRINT_FOURTH_COUNT = "4개 일치 (50,000원) - %d개"
        const val PRINT_THIRD_COUNT = "5개 일치 (1,500,000원) - %d개"
        const val PRINT_SECOND_COUNT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val PRINT_FIRST_COUNT = "6개 일치 (2,000,000,000원) - %d개"
        const val RATE_PERCENT = 100

    }
}