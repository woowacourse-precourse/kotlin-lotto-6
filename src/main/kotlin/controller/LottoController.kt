package controller

import model.Lotto
import model.Money
import model.WinningNumbersManager
import util.Calculator.clearWinningAmountValue
import util.Calculator.getProfitPercentage
import util.Calculator.plusWinningAmount
import util.LottoConfiguration
import util.LottoStore.generateLottoTickets
import view.InputView
import view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {

    private lateinit var money: Money
    private lateinit var winningNumbersManager: WinningNumbersManager
    private var purchasedLottoTickets = mutableListOf<Lotto>()
    private val rankFrequencyData = HashMap<Int, Int>()
    fun run() {
        inputPrice()
        generateLotto()
        printLottoInfo()
        inputWinningNumber()
        inputBonusNumber()
        getRankedValue()
        printRankedValue()
        getProfitPercentage()
    }

    private fun inputPrice() {
        do {
            outputView.printPurchaseAmount()
            val inputPrice = inputView.getValue()
            try {
                money = Money(inputPrice)
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e)
                continue
            }
            break
        } while (true)
    }

    private fun generateLotto() {
        do {
            try {
                purchasedLottoTickets.add(generateLottoTickets())
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e)
                continue
            }
        } while (purchasedLottoTickets.size != money.getPurchasableLottoTicketCount())
    }

    private fun printLottoInfo() {
        outputView.printPurchasedItemCount(money.getPurchasableLottoTicketCount())
        purchasedLottoTickets.forEach { lotto ->
            outputView.printLottoInfo(lotto.getNumberInfo())
        }
    }

    private fun inputWinningNumber() {
        do {
            outputView.printEnterWinningNumberMessage()
            try {
                winningNumbersManager = WinningNumbersManager(inputView.getValue().split(","))
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e)
                continue
            }
            break
        } while (true)
    }

    private fun inputBonusNumber() {
        do {
            outputView.printEnterBonusNumberMessage()
            try {
                winningNumbersManager.isBonusNumberValid(inputView.getValue())
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e)
                continue
            }
            break
        } while (true)
    }

    private fun getRankedValue() {
        for (lotto in purchasedLottoTickets) {
            val rank = winningNumbersManager.getRank(lotto.getNumberInfo())
            if (rankFrequencyData.containsKey(rank)) {
                rankFrequencyData[rank] = rankFrequencyData[rank]!! + 1
                continue
            }
            rankFrequencyData[rank] = 1
        }
    }

    private fun printRankedValue() {
        outputView.printResultMessage()
        for (rank in LottoConfiguration.MIN_OUTPUT_RANK.value downTo LottoConfiguration.MAX_OUTPUT_RANK.value) {
            outputView.printWinningStatistics(rank, rankFrequencyData[rank] ?: 0)
        }
    }

    private fun getProfitPercentage() {
        clearWinningAmountValue()
        for (rank in LottoConfiguration.MIN_OUTPUT_RANK.value downTo LottoConfiguration.MAX_OUTPUT_RANK.value) {
            plusWinningAmount(rank, (rankFrequencyData[rank] ?: 0))
        }
        outputView.printProfitPercentage(getProfitPercentage(purchasedLottoTickets.size))
    }
}
