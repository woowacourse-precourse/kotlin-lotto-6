package lotto.view

import lotto.model.Lotto
import lotto.utils.Notice

class Output {
    fun startGameNotice() {
        println(Notice.PURCHASE_PAYMENT.message)
    }

    fun showLottoCount(lottoCount: Int) {
        println()
        println(lottoCount.toString()+Notice.PURCHASED_TICKET_NUMS.message)
    }

    fun getWinningInfoNotice() {
        println()
        println(Notice.ENTER_WINNING_INFO.message)
    }

    fun getBonusInfoNotice() {
        println()
        println(Notice.ENTER_BONUS_INFO.message)
    }

    fun showResult(lottoResults: Pair<List<Int>, String>) {
        val ranks = lottoResults.first
        val rate = lottoResults.second
        println()
        println(Notice.WINNING_STATISTICS.message)
        println(Notice.HYPHENS.message)
        for (i in 5 downTo 1){
            println(getMatchCount(i) + ranks[i].toString() + Notice.COUNT.message)
        }

        println(Notice.PRESENT_RATE_FIRST.message + rate + Notice.PRESENT_RATE_SECOND.message)
    }

    private fun getMatchCount(i: Int): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(getMatchNums(i))
        stringBuilder.append("개 일치")
        if (i == 2){
            stringBuilder.append(", 보너스 볼 일치")
        }
        stringBuilder.append(" (")
        stringBuilder.append(getReward(i))
        stringBuilder.append("원) - ")
        return stringBuilder.toString()
    }

    private fun getMatchNums(i: Int): Int {
        when(i){
            5 -> return 3
            4 -> return 4
            3 -> return 5
            2 -> return 5
            1 -> return 6
        }
        return 0
    }

    private fun getReward(i: Int): String {
        when(i){
            5 -> return "5,000"
            4 -> return "50,000"
            3 -> return "1,500,000"
            2 -> return "30,000,000"
            1 -> return "2,000,000,000"
        }
        return ""
    }

    fun showLottos(autoLottoTickets: List<Lotto>) {
        autoLottoTickets.forEach {
            println(it)
        }
    }
}