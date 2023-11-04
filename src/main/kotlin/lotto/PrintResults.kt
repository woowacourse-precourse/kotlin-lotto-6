package lotto

class PrintResults {
    fun printResults(prizeCounts: IntArray, rateOfReturn: Double) {
        val prizeDescriptions = listOf(
                "3개 일치 (5,000원)",
                "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)"
        )

        println("\n당첨 통계\n---")
        for (i in 0 until prizeCounts.size) {
            println("${prizeDescriptions[i]} - ${prizeCounts[i]}개")
        }

        println("총 수익률은 ${roundDigit(rateOfReturn, 1)}%입니다.")
    }

    fun roundDigit(number: Double, digits: Int): Double {
        return Math.round(number * Math.pow(10.0, digits.toDouble())) / Math.pow(10.0, digits.toDouble())
    }
}