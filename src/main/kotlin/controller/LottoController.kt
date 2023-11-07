package controller

import model.Lotto
import model.Money
import model.WinningNumbersManager
import util.Calculator.getProfitPercentage
import util.Calculator.plusWinningAmount
import util.LottoStore.generateLottoTickets
import view.InputView
import view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {

    private lateinit var money: Money
    private lateinit var winningNumbersManager: WinningNumbersManager
    private var purchasedLottoTickets = mutableListOf<Lotto>()
    private var winningAmount = 0L
    fun run() {
        do {
            outputView.printPurchaseAmount()
            val inputPrice = inputView.getValue()
            try {
                money = Money(inputPrice)
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
                e.printStackTrace()
                Thread.sleep(100)
                continue
            }
            break
        } while (true)

        outputView.printAppendLine()

        do {
            try {
                purchasedLottoTickets.add(generateLottoTickets())
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
                e.printStackTrace()
                Thread.sleep(100)
                continue
            }
        } while (purchasedLottoTickets.size != money.getPurchasableLottoTicketCount())

        outputView.printPurchasedItemCount(money.getPurchasableLottoTicketCount())
        purchasedLottoTickets.forEach { lotto ->
            outputView.printLottoInfo(lotto.getNumberInfo())
        }

        do {
            outputView.printAppendLine()
            outputView.printEnterWinningNumberMessage()
            try {
                val inputWinningNumber = inputView.getValue()
                winningNumbersManager = WinningNumbersManager(inputWinningNumber.split(","))
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
                e.printStackTrace()
                Thread.sleep(100)
                continue
            }
            break
        } while (true)

        do {
            outputView.printAppendLine()
            outputView.printEnterBonusNumberMessage()
            val inputBonusNumber = inputView.getValue()
            try {
                winningNumbersManager.isBonusNumberValid(inputBonusNumber)
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
                e.printStackTrace()
                Thread.sleep(100)
                continue
            }
            winningNumbersManager.setBonusNumber(inputBonusNumber)
            break
        } while (true)

        outputView.printAppendLine()
        outputView.printResultMessage()

        val rankFrequencyData = HashMap<Int, Int>()
        for (lotto in purchasedLottoTickets) {
            val rank = winningNumbersManager.getRank(lotto.getNumberInfo())
            if (rankFrequencyData.containsKey(rank)) {
                rankFrequencyData[rank] = rankFrequencyData[rank]!! + 1
                continue
            }
            rankFrequencyData[rank] = 1
        }

        for (rank in 6 downTo 1) {
            outputView.printWinningStatistics(rank, rankFrequencyData[rank] ?: 0)
            plusWinningAmount(rank, (rankFrequencyData[rank] ?: 0))
        }
        outputView.printProfitPercentage(getProfitPercentage(purchasedLottoTickets.size))
    }
}
