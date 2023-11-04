
import lotto.Lotto
import lotto.domain.LottoWrapper
import lotto.domain.Purchase
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoManager(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val purchase = Purchase()
        val amount = purchase.buyLotto()
        val ticket = purchase.calculateTicket(amount)
        outputView.showBuyTicketMessage(ticket)

        val lottoWrapper = LottoWrapper()
        val lottoList = lottoWrapper.reapeatLottoNumbers(ticket)

        outputView.showLottoNumbers(lottoList)

        val winningLotto = WinningLotto()
        val winningNumbers = winningLotto.createWinningLotto()

        val lotto = Lotto(winningNumbers)
    }
}