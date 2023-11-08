package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.Lotto.Companion.LOTTO_PRICE_PER_GAME
import lotto.MoneyUtils
import lotto.domain.Rank
import lotto.presentation.InputBonusNumber
import lotto.presentation.InputWinningNumber
import lotto.presentation.LottoGameView
import lotto.toDecimalFormat

class LottoGameController {
    private val lottoGameView = LottoGameView()
    private var lottoTickets = emptyList<Lotto>()
    private var winningNumbers = emptyList<Int>()
    private var bonusNumber = 0
    private val results = mutableMapOf<Rank, Int>(
        Rank.FIFTH to 0,
        Rank.FOURTH to 0,
        Rank.THIRD to 0,
        Rank.SECOND to 0,
        Rank.FIRST to 0,
    )

    fun start() {
        val purchaseMoney = requestPurchaseMoney()
        purchaseLottoTickets(purchaseMoney)
        lottoGameView.printPurchasedLottos(lottoTickets)

        winningNumbers = requestWinningNumber()
        bonusNumber = requestBonusNumber()
    }

    fun result() {
        checkLottoTicketResult()
        printAllLottoTicketResult()

        val profitRate = calculateProfitRate()
        printProfitRate(profitRate)
    }

    private fun purchaseLottoTickets(purchaseMoney: Int) {
        val ticketAmount = purchaseMoney / LOTTO_PRICE_PER_GAME
        lottoTickets = (1..ticketAmount).map { createRandomLottoTicket() }
    }

    private fun createRandomLottoTicket(): Lotto {
        return Lotto.generateRandomLottoNumbers()
    }

    private fun requestPurchaseMoney(): Int {
        lottoGameView.requestPurchaseMoney()
        return getInputMoney()
    }

    private fun getInputMoney(): Int {
        var inputMoney = ""
        var isValid = false
        while (!isValid) {
            try {
                inputMoney = Console.readLine()
                MoneyUtils.validateInputMoney(inputMoney)
                isValid = true
            } catch (exception: IllegalArgumentException) {
                lottoGameView.printErrorMessage(exception.message)
            }
        }
        return inputMoney.toInt()
    }

    private fun requestWinningNumber(): List<Int> {
        lottoGameView.requestWinningNumbers()
        return getInputWinningNumber()
    }

    private fun getInputWinningNumber(): List<Int> {
        var inputWinningNumbers = ""
        var isValidInput = false
        while (!isValidInput) {
            try {
                inputWinningNumbers = Console.readLine()
                InputWinningNumber.validate(inputWinningNumbers)
                isValidInput = true
            } catch (exception: IllegalArgumentException) {
                lottoGameView.printErrorMessage(exception.message)
            }
        }
        return inputWinningNumbers.split(",").map(Integer::parseInt)
    }

    private fun requestBonusNumber(): Int {
        lottoGameView.requestBonusNumbers()
        return getInputBonusNumber()
    }

    private fun getInputBonusNumber(): Int {
        var inputBonusNumbers = ""
        var isValidInput = false
        while (!isValidInput) {
            try {
                inputBonusNumbers = Console.readLine()
                InputBonusNumber.validate(inputBonusNumbers, winningNumbers)
                isValidInput = true
            } catch (exception: IllegalArgumentException) {
                lottoGameView.printErrorMessage(exception.message)
            }
        }
        return inputBonusNumbers.toInt()
    }

    private fun checkLottoTicketResult() {
        lottoTickets.forEach {
            val matchedNumbers = it.getNumbers().intersect(winningNumbers).size
            val isBonusMatched = matchedNumbers == 5 && it.getNumbers().contains(bonusNumber)

            val lottoRank = Rank.fromMatchedNumbers(matchedNumbers, isBonusMatched)
            if (lottoRank != Rank.NONE) results[lottoRank] = results.getOrDefault(lottoRank, 0) + 1
        }
    }

    private fun printAllLottoTicketResult() {
        lottoGameView.lottoResult()
        results.forEach { (rank, count) ->
            val prize = rank.prize
            println("${rank.description} (${prize.toDecimalFormat()}원) - ${count}개")
        }
    }

    private fun calculateProfitRate(): Float {
        var profit = 0L
        results.forEach { (rank, count) ->
            profit += rank.prize * count
        }

        val moneySpent = lottoTickets.size * LOTTO_PRICE_PER_GAME
        return (profit * 100f) / moneySpent
    }

    private fun printProfitRate(profitRate: Float) {
        println("총 수익률은 ${"%.1f".format(profitRate)}%입니다.")
    }
}