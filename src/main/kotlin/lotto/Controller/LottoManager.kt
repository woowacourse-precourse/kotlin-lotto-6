package lotto.Controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.utils.Constants
import lotto.validate.ValidateSplit
import lotto.view.InputView
import lotto.view.OutputView

class LottoManager(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        outputView.showInputBuyPriceMessage()
        val buyPrice = inputView.inputBuyPrice()
        val ticket = calculateTicket(buyPrice)
        outputView.showBuyTicketMessage(ticket)
        outputView.showInputMyNumbersMessage()

        val numbers = inputView.inputMyNumbers()
        val lottoNumbers = splitMyNumbers(numbers)
        val lotto = Lotto(changeStringToInteger(lottoNumbers))

        reapeatLottoNumbers(ticket)
    }

    private fun changeStringToInteger(numbers: List<String>) : List<Int> {
        return numbers.map { it.toInt() }
    }

    fun calculateTicket(buyPrice: Int): Int {
        return buyPrice / Constants.THOUSAND_PRICE
    }

    private fun splitMyNumbers(myNumbers: String): List<String> {
        val validateSplit = ValidateSplit()
        return validateSplit.validateSplitMyNumbers(myNumbers.split(Constants.DELIMITER))
    }

    fun reapeatLottoNumbers(ticket: Int) {
        repeat(ticket) {
            generateLottoNumbers()
        }
    }
    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            Constants.LOTTO_START_NUMBER, Constants.LOTTO_LAST_NUMBER, Constants.LOTTO_SIZE
        )
    }

}