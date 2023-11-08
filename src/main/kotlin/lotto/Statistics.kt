package lotto

class Statistics {
    companion object {
        fun howManyWins(winNumbers: List<Int>, user: User) {
            for (lotto in user.lottoTickets) {
                compareWinNumbers(winNumbers, lotto, user.bonusNumber)
            }
            val returnRate = rateOfReturn(user.purchaseMoney)
            printResult(returnRate)
        }

        private fun compareWinNumbers(winNumbers: List<Int>, lotto: List<Int>, bonus: Int) {
            var counts: Int = 0
            for (winNumber in winNumbers) {
                if (lotto.contains(winNumber)) {
                    counts++
                }
            }
            if (counts == 3) WinEnum.FIFTH.counts++
            else if (counts == 4) WinEnum.FOURTH.counts++
            else if (counts == 5){
                if (lotto.contains(bonus)) WinEnum.SECOND.counts++
                else WinEnum.THIRD.counts++
            }
            else if (counts == 6) WinEnum.FIRST.counts
        }

        private fun rateOfReturn(purchaseMoney: Int): Double {
            val benefit = WinEnum.FIFTH.win * WinEnum.FIFTH.counts
            +WinEnum.FOURTH.win * WinEnum.FOURTH.counts
            +WinEnum.THIRD.win * WinEnum.THIRD.counts
            +WinEnum.SECOND.win * WinEnum.SECOND.counts
            +WinEnum.FIRST.win * WinEnum.FIRST.counts
            return (benefit / purchaseMoney) * 100.0
        }

        private fun printResult(returnRate: Double) {
            val roundOff = String.format("%.2f", returnRate)
            println("\n당첨 통계\n---")
            println(WinEnum.FIFTH.printer)
            println(WinEnum.FOURTH.printer)
            println(WinEnum.THIRD.printer)
            println(WinEnum.SECOND.printer)
            println(WinEnum.FIRST.printer)
            println("총 수익률은 ${roundOff}%입니다.")
        }
    }
}