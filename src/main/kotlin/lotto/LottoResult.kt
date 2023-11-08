package lotto

class LottoResult(private val results: List<Int>, private val bonusNumber: Int, private val purchaseAmount: Int) {

    fun displayResults() {
        println("\n당첨 통계")
        println("---")

        val count3Matches = results.count { it == 3 }
        val count4Matches = results.count { it == 4 }
        val count5Matches = results.count { it == 5 }
        val count6Matches = results.count { it == 6 }
        val count5WithBonus = results.count { it == 5 && bonusNumber == 1 }

        val prizeMoney = listOf("5,000", "50,000", "1,500,000", "30,000,000", "2,000,000,000")

        for (i in 3..5) {
            val count = results.count { it == i }
            val prize = prizeMoney[i - 3]

            println("${i}개 일치 (${prize}원) - ${count}개")

        }
        if (count5WithBonus >= 0) {
            val prize = prizeMoney[3]
            println("5개 일치, 보너스 볼 일치 (${prize}원) - ${count5WithBonus}개")
        }
        if (count6Matches >= 0) {
            val prize = prizeMoney[4]
            println("6개 일치 (${prize}원) - ${count6Matches}개")
        }

        val totalPrize = count3Matches * prizeMoney[3].replace(",", "").toInt() +
                count4Matches * prizeMoney[3].replace(",", "").toInt() +
                count5Matches * prizeMoney[3].replace(",", "").toInt() +
                count5WithBonus * prizeMoney[3].replace(",", "").toInt() +
                count6Matches * prizeMoney[4].replace(",", "").toInt()
        val profitRate = ((totalPrize - purchaseAmount) / purchaseAmount.toDouble()) * 100
        println("총 수익률은 %.1f%%입니다.".format(profitRate))
    }
}
