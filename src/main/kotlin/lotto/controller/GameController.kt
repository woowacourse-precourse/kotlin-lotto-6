package lotto.controller

import lotto.Constants
import lotto.model.BuyingAmount
import lotto.model.Lottos
import lotto.model.LottosMatchCount
import lotto.model.RateOfReturn
import lotto.util.Task
import lotto.view.InputView
import lotto.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private val inputController = InputController(inputView)
    private val lottosMatchCount = LottosMatchCount()

    // TODO: 가능하면 멤버 변수에서 빼기
    private lateinit var buyingAmount: BuyingAmount
    private lateinit var lottos: Lottos

    fun play(task: Task) {
        while (task.state != Task.State.DONE) {
            try {
                processLotto(task)
            } catch (e: IllegalArgumentException) {
                handleException(e)
            } catch (e: IllegalStateException) {
                handleException(e)
            } catch (e: UninitializedPropertyAccessException) {
                handleException(e)
            }
        }
    }

    private fun handleException(e: Exception) = e.message?.let { outputView.printError(it) }

    private fun processLotto(task: Task) {
        when (task.state) {
            Task.State.BUYING_AMOUNT -> processBuyingAmount(task)
            Task.State.WINNING_AND_BONUS_NUMBERS -> processWinningAndBonusNumbers(task, lottos)
            Task.State.RATE_OF_RETURN -> processRateOfReturn(task, buyingAmount)

            else -> throw IllegalStateException(TASK_IS_INCORRECT_CONDITION)
        }
    }

    private fun processBuyingAmount(task: Task) {
        buyingAmount = inputController.BuyingAmount().also { task.nextState() }

        lottos = Lottos.createRandomNumbers(buyingAmount.amount / Constants.LOTTO_PRICE)

        outputView.printBuyingResults(lottos)
    }

    private fun processWinningAndBonusNumbers(task: Task, lottos: Lottos) {
        val winningAndBonusNumbers = inputController.WinningAndBonusNumbers().also { task.nextState() }

        lottos.calculateMatch(lottosMatchCount, winningAndBonusNumbers)

        outputView.printWinningResults(lottosMatchCount.result)
    }

    private fun processRateOfReturn(task: Task, buyingAmount: BuyingAmount) {
        val rateOfReturn = RateOfReturn(lottosMatchCount.result, buyingAmount.amount).also { task.nextState() }

        val result = rateOfReturn.calculate()

        outputView.printRateOfReturn(result)
    }

    companion object {
        private const val TASK_IS_INCORRECT_CONDITION = "Task.inputState 값이 올바르지 않습니다."
    }
}