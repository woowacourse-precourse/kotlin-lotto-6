package lotto


class LottoResult() {
    private val ranks = listOf("FIFTH", "FOURTH", "THIRD", "SECOND", "FIRST")

    fun getResult(winningNumbers: WinningNumbers, userTickets: List<Lotto>): Map<String, Int> {
        var result = mutableMapOf(
            "FIRST" to 0,
            "SECOND" to 0,
            "THIRD" to 0,
            "FOURTH" to 0,
            "FIFTH" to 0,
            "NOTHING" to 0,
        )
        for (ticket in userTickets)
            result[ticket.checkLotto(winningNumbers)] =
                result[ticket.checkLotto(winningNumbers)]!! + 1
        return result
    }

    fun printResult(results: Map<String, Int>, userCost: Int) {
        println("\n당첨 통계\n---")
        for (rank in ranks) {
            if (rank == "SECOND") {
                println("${Reward.getSameCount(rank)}개 일치, 보너스 볼 일치 (${Reward.getPrizeMoney(rank)}원) - ${results[rank]}개")
                continue
            }
            println("${Reward.getSameCount(rank)}개 일치 (${Reward.getPrizeMoney(rank)}원) - ${results[rank]}개")
        }
        println("총 수익률은 ${getProfit(results, userCost)}%입니다.")

    }

    private fun getProfit(results: Map<String, Int>, userCost: Int): String {
        var sum = 0.0
        var prize: String
        for (rank in ranks) {
            prize = Reward.getPrizeMoney(rank).replace(",", "")
            sum += (prize.toLong() * results[rank]!!)
        }

        return (sum / userCost * 100).toString()
    }
}
