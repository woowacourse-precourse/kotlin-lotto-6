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
            result[ticket.check(winningNumbers)] = result[ticket.check(winningNumbers)]!! + 1
        }
        return result
    }
}
