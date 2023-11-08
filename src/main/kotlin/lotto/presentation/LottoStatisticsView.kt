package lotto.presentation

import LOTTO_FIFTH_RANK_MESSAGE
import LOTTO_FIRST_RANK_MESSAGE
import LOTTO_FOURTH_RANK_MESSAGE
import LOTTO_SECOND_RANK_MESSAGE
import LOTTO_STATISTICS_MESSAGE
import LOTTO_THIRD_RANK_MESSAGE
import MATCH_COUNT
import lotto.model.LottoResult

object LottoStatisticsView {
    fun printStatistics(ranks: List<Int>) {
        println()
        println(LOTTO_STATISTICS_MESSAGE)
        printLottoRank(ranks)
    }

    fun printLottoRank(ranks: List<Int>) {
        val lottoResults = LottoResult.values().toList()
        val messages = mutableListOf<String>()

        for ((index, rank) in lottoResults.withIndex()) {
            val count = ranks[index]
            val messageText = when (rank) {
                LottoResult.FIRST -> LOTTO_FIRST_RANK_MESSAGE
                LottoResult.SECOND -> LOTTO_SECOND_RANK_MESSAGE
                LottoResult.THIRD -> LOTTO_THIRD_RANK_MESSAGE
                LottoResult.FOURTH -> LOTTO_FOURTH_RANK_MESSAGE
                LottoResult.FIFTH -> LOTTO_FIFTH_RANK_MESSAGE
            }
            val formattedMessage = messageText.replace(MATCH_COUNT, count.toString())
            messages.add(formattedMessage)
        }
        printReverseLottoRank(messages)
    }

    fun printReverseLottoRank(messages: List<String>) {
        messages.reversed().forEach {
            println(it)
        }
    }
}