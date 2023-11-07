package lotto.view

import lotto.model.Lotto
import lotto.utils.Notice

class Output {
    fun startGameNotice() {
        println(Notice.PURCHASE_PAYMENT)
    }

    fun showLottoTickets(generatedAutoLottoTickets: List<Lotto>) {
        println(generatedAutoLottoTickets.size.toString()+Notice.PURCHASED_TICKET_NUMS)
        for (ticket in generatedAutoLottoTickets){
            println(ticket)
        }
    }

    fun getWinningInfoNotice() {
        println(Notice.ENTER_WINNING_INFO)
    }

    fun getBonusInfoNotice() {
        println(Notice.ENTER_BONUS_INFO)
    }

    fun showResult(lottoResults: Pair<List<Int>, Double>) {
        val ranks = lottoResults.first
        val rate = lottoResults.second
        println(Notice.WINNING_STATISTICS)
        println(Notice.HYPHENS)
        for (i in 5 downTo 1){
            println(getMatchCount(i) + ranks[i].toString() + Notice.COUNT)
        }

        println(Notice.PRESENT_RATE_FIRST.toString() + rate.toString() + Notice.PRESENT_RATE_SECOND)
    }

    private fun getMatchCount(i: Int): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(i)
        stringBuilder.append("개 일치 (")
        stringBuilder.append(getReward(i))
        stringBuilder.append("원) - ")
        return stringBuilder.toString()
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
}