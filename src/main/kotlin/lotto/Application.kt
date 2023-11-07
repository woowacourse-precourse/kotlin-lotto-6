package lotto

import lotto.domain.Lotto
import lotto.domain.Winning
import lotto.util.NumberPicker
import lotto.util.RateOfReturnCalculator.calculateRateOfReturn
import lotto.util.doLogic
import lotto.util.lottoPrice
import lotto.util.validations.LottoBonusNumbersValidator
import lotto.util.validations.LottoNumbersValidator
import lotto.util.validations.PriceValidator
import lotto.view.InputView
import lotto.view.OutputView

var numberOfLottoTickets = 0
val lottos = mutableListOf<Lotto>()
lateinit var userLottos: Lotto
var userLottoBonusNumber = 0
val winnings = Winning.values()

fun main() {
    doLotto()
}

fun doLotto() {
    doLogic {
        val lottoPurchaseAmount = getLottoPurchaseAmount()
        getNumberOfLottoTickets(lottoPurchaseAmount)
    }
    getLottoWinningNumbers()
    showLottoWinningNumbers()
    doLogic {
        val userInputNumbers = getUserLottoNumbers()
        validateUserLottoNumbers(userInputNumbers)
    }
    doLogic {
        val userInputBonusNumber = getUserBonusLottoNumber()
        validateUserBonusLottoNumber(userInputBonusNumber)
    }
    checkWinning()
    showWinningResult()
    showRateOfReturn()
}

fun showLottoWinningNumbers() {
    lottos.forEach {
        it.printWinningNumbers()
    }
}

fun getLottoPurchaseAmount(): String {
    OutputView.printPriceMessage()
    return InputView.inputPrice()
}

fun getNumberOfLottoTickets(lottoPurchaseAmount: String) {
    val lottoTickets = lottoPurchaseAmount.toIntOrNull()
    if (PriceValidator.inputPrice(lottoPurchaseAmount)) {
        OutputView.printLottoCountMessage(lottoTickets!! / lottoPrice)
        numberOfLottoTickets = lottoTickets / lottoPrice
    }
}

fun getLottoWinningNumbers() {
    repeat(numberOfLottoTickets) {
        val numbers = NumberPicker.pickNumbers()
        Lotto(numbers).apply {
            lottos.add(this)
        }
    }
}

fun getUserLottoNumbers(): String {
    return InputView.inputNumbers()
}

fun validateUserLottoNumbers(userInputNumbers: String) {
    val parsedUserInputNumbers = userInputNumbers.split(",").filter {
        it.isNotEmpty()
    }.map {
        it.toIntOrNull()
    }
    if (LottoNumbersValidator.inputNumbers(parsedUserInputNumbers)) {
        parsedUserInputNumbers.map { it!! }.apply {
            Lotto(this).apply {
                userLottos = this
            }
        }
    }
}

fun getUserBonusLottoNumber(): String {
    return InputView.inputBonusNumber()
}

fun validateUserBonusLottoNumber(userInputBonusNumber: String) {
    if (LottoBonusNumbersValidator.inputNumber(userInputBonusNumber)) {
        userInputBonusNumber.toInt().apply {
            userLottoBonusNumber = this
        }
    }
}

fun checkWinning() {
    lottos.forEach {
        val winningResult = it.checkWinning(userLottos, userLottoBonusNumber)
        winnings.toList().indexOf(winningResult).apply {
            if (this >= 0) winnings[this].winningCnt++
        }
    }
}

fun showWinningResult() {
    OutputView.printWinningStatisticsMessage()
    winnings.forEach {
        OutputView.printWinningResult(it.msg, it.winningPrice, it.winningCnt)
    }
}

fun showRateOfReturn() {
    val totalWinningPrice = winnings.fold(0) { acc, winning ->
        acc + winning.winningPrice * winning.winningCnt
    }
    val totalRateOfReturn = calculateRateOfReturn(totalWinningPrice)
    OutputView.printTotalRateOfReturnMessage(totalRateOfReturn)
}