package lotto.domain

enum class Prize(val correct: Int, val reward: Int, val winningResult: String) {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"),
    NONE(0, 0, "");

    companion object {
        fun checkRank(correctCount: Int, hasBonus: Boolean): Prize =
            when (correctCount) {
                FIRST.correct -> FIRST
                SECOND.correct -> if (hasBonus) SECOND else THIRD
                FOURTH.correct -> FOURTH
                FIFTH.correct -> FIFTH
                else -> NONE
            }

    }
}

class Result {
    fun checkTickets(tickets: List<List<Int>>, drawNumber: List<Int>, bonusNumber: Int): Map<Prize, Int> {
        val checkedTickets = mutableMapOf<Prize, Int>()
        for (ticket in tickets) {
            val rank = checkTicket(ticket, drawNumber, bonusNumber)
            checkedTickets[rank] = checkedTickets.getOrDefault(rank, DEFAULT_VALUE) + PLUS_COUNT
        }
        return checkedTickets
    }

    fun checkTicket(ticket: List<Int>, drawNumber: List<Int>, bonusNumber: Int): Prize {
        val correctCount = ticket.intersect(drawNumber.toSet()).size
        val hasBonus = ticket.contains(bonusNumber)
        return Prize.checkRank(correctCount, hasBonus)
    }

    fun calculatePrize(countEachPrize: Map<Prize, Int>): Int {
        val calculatePrize = countEachPrize.mapValues { it.value * it.key.reward }
        return calculatePrize.values.sum()
    }

    companion object {
        const val DEFAULT_VALUE = 0
        const val PLUS_COUNT = 1
    }
}