package lotto.View

import lotto.Controller.LottoController

class LottoView {
    fun printMessage(message: String) {
        println(message)
    }

    fun printLottoNumbers(lottoCount: Int, lottoList: List<List<Int>>) {
        printMessage("\n${lottoCount}개를 구매했습니다.")
        lottoList.forEach { lotto ->
            printMessage(lotto.sorted().joinToString(", ", "[", "]"))
        }
        println()
    }

    fun printResult(result: Map<String, Int>, lottoCount: Int) {
        printMessage("\n당첨 통계")
        printMessage("---")
        var totalPrize = 0
        val prizeMoney = mapOf(
            "3개 일치" to 5000,
            "4개 일치" to 50000,
            "5개 일치" to 1500000,
            "5개 일치, 보너스 볼 일치" to 30000000,
            "6개 일치" to 2000000000
        )
        for ((key, value) in result) {
            val prize = when (key) {
                "5개 일치" -> if (result[LottoController.LottoPrize.fiveSamePlusBonus.prizeName] == 0) "1,500,000원" else "30,000,000원"
                else -> "${prizeMoney[key]?.let { "%,d".format(it) }}원"
            }
            printMessage("$key ($prize) - $value 개")
            totalPrize += if (key == "5개 일치") {
                if (result[LottoController.LottoPrize.fiveSamePlusBonus.prizeName] == 0) prizeMoney["5개 일치"]!! * value else prizeMoney["5개 일치, 보너스 볼 일치"]!! * value
            } else {
                prizeMoney[key]!! * value
            }
        }
        val inputMoney = lottoCount * 1000
        val rateOfReturn = ((totalPrize - inputMoney) / inputMoney.toDouble() * 100).coerceAtLeast(0.0)
        printMessage("총 수익률은 ${"%,.1f".format(rateOfReturn)}%입니다.")
    }
}
