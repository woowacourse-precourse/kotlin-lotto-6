package controller

import model.Lotto
import model.Money
import model.WinningNumbersManager
import util.LottoStore.generateLottoTickets
import view.InputView
import view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {

    private lateinit var money: Money
    private lateinit var winningNumbersManager: WinningNumbersManager
    private var purchasedLottoTickets = mutableListOf<Lotto>()
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
            outputView.printLottoInfo(lotto.getLottoNumberInfo())
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

        val resultMap = HashMap<Int, Int>()
        for (lotto in purchasedLottoTickets) {
            val rank = winningNumbersManager.getRank(lotto.getLottoNumberInfo())
            if (resultMap.containsKey(rank)) {
                resultMap[rank] = resultMap[rank]!! + 1
                continue
            }
            resultMap[rank] = 1
        }
        for (rank in 6 downTo 1) {
            if (resultMap.containsKey(rank)) {
                outputView.printWinningStatistics(rank, resultMap[rank]!!)
                continue
            }
            outputView.printWinningStatistics(rank, 0)
        }
    }
}
