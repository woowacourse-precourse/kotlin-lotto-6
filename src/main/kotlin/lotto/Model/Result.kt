package lotto.Model

import lotto.Lotto

object Result {
    fun calculateResults(lottoTickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<String, Int> {
        val results = initializeResults()

        for (ticket in lottoTickets) {
            val matchingCount = calculateMatchingCount(ticket, winningNumbers, bonusNumber)
            results[matchingCount.toString()] = results.getOrDefault(matchingCount.toString(), 0) + 1
        }

        return results
    }

    fun calculateMatchingCount(ticket: Lotto, winningNumbers: List<Int>, bonusNumber: Int): Int {
        val numbers = ticket.getNumbers()  // getNumbers() 함수를 사용하여 로또 번호 가져오기
        val matchingCount = numbers.filter { winningNumbers.contains(it) }.count()

        return when {
            matchingCount == 6 -> 6
            matchingCount == 5 && numbers.contains(bonusNumber) -> 51
            else -> matchingCount.toInt()
        }
    }

    private fun initializeResults(): MutableMap<String, Int> {
        val results = mutableMapOf(
                "0" to 0,
                "1" to 0,
                "2" to 0,
                "3" to 0,
                "4" to 0,
                "5" to 0,
                "5.1" to 0,
                "6" to 0
        )
        return results
    }


}
