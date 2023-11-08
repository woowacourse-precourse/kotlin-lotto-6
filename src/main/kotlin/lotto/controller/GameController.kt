package lotto.controller

import lotto.Constants
import lotto.dto.WinningAndBonusNumbers
import lotto.model.BonusNumber
import lotto.model.BuyingAmount
import lotto.model.Lotto
import lotto.model.LottoCalculator
import lotto.model.Lottos
import lotto.model.LottosMatchCount
import lotto.model.RateOfReturn
import lotto.model.WinningNumbers
import lotto.model.validation.WinningValidation
import lotto.util.Task
import lotto.view.InputView
import lotto.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    // TODO: 가능하면 멤버 변수에서 빼기
    lateinit var buyingAmount: BuyingAmount
    lateinit var lottos: Lottos

    fun play(task: Task) {
        while (task.inputState != Task.State.DONE) {
            try {
                mainProcess(task)
            } catch (e: IllegalArgumentException) {
                handleException(e)
            } catch (e: IllegalStateException) {
                handleException(e)
            } catch (e: UninitializedPropertyAccessException) {
                handleException(e)
            }
        }
    }

    fun handleException(e: Exception) {
        e.message?.let { outputView.printError(it) }
    }

    private fun mainProcess(task: Task) {
        when (task.inputState) {
            Task.State.INPUT_BUYING_AMOUNT -> processBuyingAmount(task)
            Task.State.INPUT_WINNING_AND_BONUS_NUMBERS ->
                processWinningAndBonusNumbers(task, lottos.lottoNumbers)

            else -> throw IllegalStateException(TASK_IS_INCORRECT_CONDITION)
        }
    }

    private fun processBuyingAmount(task: Task) {
        buyingAmount = inputToClassInstance({ inputView.buyingAmountPrompt() }, ::BuyingAmount)
        task.inputState = Task.State.INPUT_WINNING_AND_BONUS_NUMBERS

        lottos = Lottos.create(buyingAmount.amount / Constants.LOTTO_PRICE)

        outputView.printBuyingResults(lottos)
    }

    private fun processWinningAndBonusNumbers(task: Task, lottos: List<Lotto>) {
        val winningAndBonusNumbers = inputWinningAndBonusNumbers()
        task.inputState = Task.State.DONE

        val lottosMatchCount = LottosMatchCount()
        calculateMatch(lottosMatchCount, lottos, winningAndBonusNumbers)

        val rateOfReturn = RateOfReturn(lottosMatchCount.result, buyingAmount.amount)
        outputView.printWinningResults(lottosMatchCount.result)
        outputView.printRateOfReturn(rateOfReturn.getData())
    }

    fun inputWinningAndBonusNumbers(): WinningAndBonusNumbers {
        val winningNumbers =
            inputToClassInstance({ inputView.winningNumbersPrompt() }, ::WinningNumbers)
        val bonusNumber = inputToClassInstance({ inputView.bonusNumberPrompt() }, ::BonusNumber)

        WinningValidation(winningNumbers.numbers, bonusNumber.number)

        return WinningAndBonusNumbers(winningNumbers.numbers, bonusNumber.number)
    }

    fun calculateMatch(
        lottosMatchCount: LottosMatchCount,
        lottos: List<Lotto>,
        winningAndBonusNumbers: WinningAndBonusNumbers
    ) {
        lottos.forEach {
            val lottoMatchResult = LottoCalculator.matchCount(
                it.numbers, winningAndBonusNumbers
            )
            lottosMatchCount.update(lottoMatchResult)
        }
    }

    private fun <T> inputToClassInstance(
        prompt: (InputView) -> String,
        className: (String) -> T
    ): T {
        val userInputData = prompt(inputView)
        return className(userInputData)
    }

    companion object {
        private const val TASK_IS_INCORRECT_CONDITION = "Task.inputState 값이 올바르지 않습니다."
    }
}