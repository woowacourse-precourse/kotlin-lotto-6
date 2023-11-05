package controller

import lotto.Lotto
import model.Money
import util.LottoStore.generateLottoTickets
import view.InputView
import view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {

    private lateinit var money: Money
    private var purchasedLottoTickets = mutableListOf<Lotto>()
    fun run() {
        do {
            outputView.printPurchaseAmount()
            val inputPrice = inputView.getValue()
            try {
                money = Money(inputPrice)
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
                continue
            }
            break
        } while (true)

        outputView.printPurchasedItemCount(money.getPurchasableLottoTicketCount())
        do {
            try {
                purchasedLottoTickets.add(generateLottoTickets())
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
                continue
            }
            break
        } while (purchasedLottoTickets.size != money.getPurchasableLottoTicketCount())

    }
}
