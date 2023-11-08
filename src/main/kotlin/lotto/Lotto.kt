package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        this.validateLotto()
    }

    fun winningCount(tickets: ArrayList<List<Int>>, bonusNum: Int): ArrayList<Int> {
        val countWinning = arrayListOf(0, 0, 0, 0, 0)
        for (i in 0..tickets.size - 1) {
            var count = 0
            if (tickets[i].contains(numbers[0])) count += 1
            if (tickets[i].contains(numbers[1])) count += 1
            if (tickets[i].contains(numbers[2])) count += 1
            if (tickets[i].contains(numbers[3])) count += 1
            if (tickets[i].contains(numbers[4])) count += 1
            if (tickets[i].contains(numbers[5])) count += 1
            if (count == 5 && tickets[i].contains(bonusNum)) countWinning[3] += 1
            else if (count == 6) countWinning[4] += 1
            else if (count >= 3) countWinning[count - 3] += 1
        }
        return countWinning
    }

    fun getProfitRate(winningCount: ArrayList<Int>, inputMoney: Int) {
        val profitRate =
            (winningCount[0] * 5000.0 + winningCount[1] * 50000.0 + winningCount[2] * 1500000.0 + winningCount[3] * 30000000.0 + winningCount[4] * 2000000000.0) / inputMoney * 100
        println("총 수익률은 ${profitRate}%입니다.")
    }

    private fun validateLotto() {
        if (numbers.size != 6)
            throw IllegalArgumentException(ValidateMsg.LOTTONUM.msg)
        if (numbers.size != numbers.distinct().count())
            throw IllegalArgumentException(ValidateMsg.REDUNDANT.msg)
        for (i in 0..this.numbers.size - 1) {
            if (this.numbers[i] < 1 || this.numbers[i] > 45)
                throw IllegalArgumentException(ValidateMsg.NUMRANGE.msg)
        }
    }
}
