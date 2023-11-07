package lotto.View

import lotto.Lotto
import lotto.Model.Prize

object Output {

    fun printLotto(lottoTickets: List<Lotto>) {
        val purchaseAmount = lottoTickets.size
        println("${purchaseAmount}개를 구매했습니다.")

        for (lottoTicket in lottoTickets) {
            val numbers = lottoTicket.getNumbers()
            println(numbers)
        }
    }

    fun printResults(results: Map<String, Int>, profitRate: Double) {
        println("당첨 통계")
        println("---")
        for (key in results.keys) {
            if (results.containsKey(key)) {
                printResultLine(key, results[key] ?: 0)
            }
        }
        println("총 수익률은 %.1f%%입니다.".format(profitRate))
    }

    private fun printResultLine(key: String, count: Int) {
        if ("5.1" == key) {
            println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${count}개")
        } else if (key.toDouble() >= 3) {
            val prize = Prize.getPrize(key)
            println("${key}개 일치 (${prize}원) - ${count}개")
        }
    }
}
