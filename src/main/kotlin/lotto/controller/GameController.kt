package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView

class GameController(private val inputView: InputView, private val outputView: OutputView) {
    private lateinit var lotto: Lotto
    private lateinit var bonus: Bonus
    private lateinit var purchase: Purchase
    private val ranking = Ranking()
    private val ticket = Ticket()

    fun start() {
        gameInit()
        setWinning()
        compareNumbers()
        printResult()
    }

    private fun gameInit() {
        setPurchase()
        ticket.issueLotto(purchase.count)
        printTickets()
    }

    private fun setWinning() {
        setLotto()
        setBonus()
    }

    private fun compareNumbers() {
        val result = Results(lotto.getWinningNumbers(), bonus.number)
        repeat(purchase.count) {round ->
            val winning = result.calculateRanking(ticket.tickets[round])
            ranking.countRanking(winning)
        }
    }

    private fun setPurchase() {
        outputView.printPriceMessage()
        calculateCount()
    }

    private fun setLotto() {
        outputView.printWinningNumberMessage()
        issueLotto()
    }

    private fun setBonus() {
        outputView.printBonusMessage()
        issueBonus()
    }

    private fun calculateCount() {
        try {
            val purchaseInput = inputView.getInteger()
            purchase = Purchase(purchaseInput)
        } catch (e: IllegalArgumentException) {
            print(e.message)
            calculateCount()
        }
    }

    private fun issueLotto() {
        try {
            val lottoInput = inputView.getLotto()
            lotto = Lotto(lottoInput)
        } catch (e: IllegalArgumentException) {
            print(e.message)
            issueLotto()
        }
    }

    private fun issueBonus() {
        try {
            val bonusInput = inputView.getInteger()
            bonus = Bonus(bonusInput)
            bonus.checkDuplication(lotto.getWinningNumbers())
        } catch (e: IllegalArgumentException) {
            print(e.message)
            issueBonus()
        }
    }

    private fun printTickets() {
        outputView.printPurchaseCountMessage(purchase)
        outputView.printTicket(ticket)

    }

    private fun printResult() {
        val prize = Prize(ranking.rank, purchase.price)
        outputView.printStatistics(ranking)
        outputView.printRate(prize)
    }
}