package lotto.service

import lotto.model.BallMachine
import lotto.model.Lotto
import lotto.model.User
import lotto.model.User.Companion.FIVE_AND_BONUS_MATCH
import lotto.model.User.Companion.FIVE_MATCH
import lotto.model.User.Companion.FOUR_MATCH
import lotto.model.User.Companion.SIX_MATCH
import lotto.model.User.Companion.THREE_MATCH
import lotto.util.Util
import lotto.view.Message

class LottoService(private val user: User, private val ballMachine: BallMachine) {

    private var lottoTicketCount = 0

    fun giveMoney() {
        try {
            println(Message.REQUEST_PURCHASE_PRICE.message)

            val requestMoney = Util.requestMoney()

            user.money = requestMoney

            lottoTicketCount = user.money / 1000

            println()
            println("$lottoTicketCount${Message.PURCHASED_LOTTO_COUNT.message}")
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return giveMoney()
        }
    }

    fun getLottoTickets() {
        user.lottoTickets = createLottoTickets(lottoTicketCount)
    }

    fun setWinningNumbers() {
        try {
            val winningNumbers = Util.requestWinningNumbers() as MutableList<Int>

            ballMachine.winningNumbers = winningNumbers

            println()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return setWinningNumbers()
        }

    }

    fun setBonusNumber() {

        try {
            val bonusNumber = Util.requestBonusNumber()

            ballMachine.bonusNumber = bonusNumber

            println()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return setBonusNumber()
        }

    }

    fun compareLottoNumber() {
        user.lottoTickets.forEach { lotto ->
            val matchCount = lotto.getNumbers().count { it in ballMachine.winningNumbers }
            val hasBonusCount = lotto.getNumbers().contains(ballMachine.bonusNumber)

            setMatchResult(matchCount, hasBonusCount)
        }
    }

    fun setTotalPrize() {
        var totalPrize = 0

        totalPrize = addAllPrize(totalPrize)

        user.totalPrize = totalPrize
    }

    private fun addAllPrize(totalPrize: Int): Int {
        var currentTotalPrize = totalPrize
        for ((matchString, count) in user.lottoResult) {
            when (matchString) {
                THREE_MATCH -> currentTotalPrize += User.THREE_MATCH_REWARD * count
                FOUR_MATCH -> currentTotalPrize += User.FOUR_MATCH_REWARD * count
                FIVE_MATCH -> currentTotalPrize += User.FIVE_MATCH_REWARD * count
                FIVE_AND_BONUS_MATCH -> currentTotalPrize += User.FIVE_AND_BONUS_MATCH_REWARD * count
                SIX_MATCH -> currentTotalPrize += User.SIX_MATCH_REWARD * count
            }
        }
        return currentTotalPrize
    }


    private fun createLottoTickets(count: Int): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()

        repeat(count) {
            val lottoTicket = Util.getLottoTicket().sorted()

            val lotto = Lotto(lottoTicket)

            lottoTickets.add(lotto)
        }

        return lottoTickets
    }

    private fun setMatchResult(matchCount: Int, hasBonusCount: Boolean) {
        when (matchCount) {
            3 -> user.setResult(THREE_MATCH)
            4 -> user.setResult(FOUR_MATCH)
            5 -> {
                if (hasBonusCount) user.setResult(FIVE_AND_BONUS_MATCH)
                if (!hasBonusCount) user.setResult(FIVE_MATCH)
            }

            6 -> user.setResult(SIX_MATCH)
        }
    }


}