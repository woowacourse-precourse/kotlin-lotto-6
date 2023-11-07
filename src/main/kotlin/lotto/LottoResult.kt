package lotto


class LottoResult() {
    private val ranks = listOf("FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH")

    fun getResult(winningNumbers: WinningNumbers, userTickets: List<Lotto>): Map<String, Int> {
        var result = mutableMapOf(
            "FIRST" to 0,
            "SECOND" to 0,
            "THIRD" to 0,
            "FORTH" to 0,
            "FIFTH" to 0,
            "NOTHING" to 0
        )
        for (ticket in userTickets) {
            result[ticket.checkLotto(winningNumbers)] = result[ticket.checkLotto(winningNumbers)]!! + 1
        }
        return result
    }

    fun printResult(results: Map<String, Int>, UserCost: Int) {
        println("당첨 통계\n---")
        for (rank in ranks) {
            if (rank == "SECOND") {
                println("${count}개 일치, 보너스 볼 일치 (${bonus})원) - 개")
                continue
            }
            println("{}개 일치 ( 원) - 개")
        }
    }
}
