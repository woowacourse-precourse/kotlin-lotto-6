package lotto.controller

import lotto.model.BonusNumber
import lotto.model.Lotto
import lotto.model.Lottos
import lotto.model.PurchaseAmount
import lotto.model.RateOfReturn
import lotto.util.Task
import lotto.model.WinningNumbers
import lotto.model.Results
import lotto.model.validation.WinningValidation
import lotto.view.InputView
import lotto.view.OutputView
import kotlin.IllegalStateException

class GameController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var lottoResults = Results()

    // TODO: 가능하면 멤버 변수에서 빼기
    lateinit var lottos: Lottos
    lateinit var purchaseAmount: PurchaseAmount


    fun play(task: Task) {
        while (task.inputState != Task.State.DONE) {
            try {
                mainProcess(task)
            } catch (e: IllegalArgumentException) {
                e.message?.let { outputView.printError(it) }
            } catch (e: IllegalStateException) {
                e.message?.let { outputView.printError(it) }
            }
        }
    }

    private fun mainProcess(task: Task) {
        when (task.inputState) {
            Task.State.INPUT_PURCHASEA_MOUNT -> processPurchaseAmount(task)
            Task.State.INPUT_WINNING_AND_BONUS_NUMBERS ->
                processWinningAndBonusNumbers(task, lottos.lottoNumbers)

            else -> throw IllegalStateException(INCORRECT_CONDITION)
        }
    }

    private fun processPurchaseAmount(task: Task) {
        purchaseAmount = inputProcess({ it.purchaseAmountPrompt() }, ::PurchaseAmount)
        task.inputState = Task.State.INPUT_WINNING_AND_BONUS_NUMBERS

        lottos = Lottos.create(purchaseAmount.amount / 1000)

        outputView.printPurchaseResults(lottos.lottoNumbers)
    }

    private fun processWinningAndBonusNumbers(task: Task, lottos: List<Lotto>) {
        val winningNumbers = inputProcess({ it.winningNumbersPrompt() }, ::WinningNumbers)
        val bonusNumber = inputProcess({ it.bonusNumberPrompt() }, ::BonusNumber)
        WinningValidation(winningNumbers.numbers, bonusNumber.number)
        task.inputState = Task.State.DONE

        lottos.forEach {
            val data = it.calculate(winningNumbers.numbers, bonusNumber.number)
            lottoResults.update(data)
        }

        val reward = RateOfReturn(lottoResults.result, purchaseAmount.amount)
        outputView.printWinnigResults(lottoResults.result)
        outputView.printRateOfReturn(reward.get())
    }

    private fun <T> inputProcess(prompt: (InputView) -> String, className: (String) -> T): T {
        val userInputData = prompt(inputView)
        return className(userInputData)
    }

    companion object {
        private const val INCORRECT_CONDITION = "입력 상태가 올바르지 않습니다."
    }
}