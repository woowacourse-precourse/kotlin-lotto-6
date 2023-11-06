package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants
import lotto.model.BonusNumber
import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.Lottos
import lotto.model.PurchaseAmount
import lotto.model.WinningNumbers
import lotto.model.WinningValidation
import lotto.view.InputView
import lotto.view.OutputView

class Task {
    var inputState: State = State.INPUT_PURCHASEA_MOUNT

    enum class State {
        INPUT_PURCHASEA_MOUNT, INPUT_WINNING_AND_BONUS_NUMBERS, DONE
    }
}

class GameController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val task = Task()
    private var result = mutableMapOf(3 to 0, 4 to 0, 50 to 0, 51 to 0, 6 to 0)
    lateinit var lottos: Lottos
    // lateinit var winningAndBonusNumberPair: Pair<WinningNumbers, BonusNumber>

    fun play() {
        while (task.inputState != Task.State.DONE) {
            try {
                mainProcess(task.inputState)
            } catch (e: Exception) {
                e.message?.let { outputView.printError(it) }
            }
        }
    }

    private fun mainProcess(inputState: Task.State) {
        when (inputState) {
            Task.State.INPUT_PURCHASEA_MOUNT ->
                lottos = processPurchaseAmount()

            Task.State.INPUT_WINNING_AND_BONUS_NUMBERS ->
                processWinningAndBonusNumbers(lottos.lottoNumbers)

            else -> throw IllegalStateException("~~~~~~~~")
        }
    }

    private fun <T> inputProcess(prompt: (InputView) -> String, className: (String) -> T): T {
        val userInputData = prompt(inputView)
        return className(userInputData)
    }

    private fun processPurchaseAmount(): Lottos {
        val purchaseAmount = inputProcess({ it.purchaseAmountPrompt() }, ::PurchaseAmount)
        task.inputState = Task.State.INPUT_WINNING_AND_BONUS_NUMBERS

        val lottoNumbers = createLottos(purchaseAmount.Count)
        val lottos = Lottos(lottoNumbers)

        outputView.printPurchaseResults(lottos)
        return lottos
    }

    private fun createLottos(count: Int): List<Lotto> {
        return List(count) {
            Lotto(createSortedUniqueNumbers())
        }
    }

    private fun createSortedUniqueNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            Constants.LOTTO_RANGE_MIN_VALUE,
            Constants.LOTTO_RANGE_MAX_VALUE,
            Constants.LOTTO_NUMBER_SIZE
        ).sorted()
    }

    private fun processWinningAndBonusNumbers(lottos: List<Lotto>) {
        val winningNumbers = inputProcess({ it.winningNumbersPrompt() }, ::WinningNumbers)
        val bonusNumber = inputProcess({ it.bonusNumberPrompt() }, ::BonusNumber)
        WinningValidation(winningNumbers.numbers, bonusNumber.number)
        task.inputState = Task.State.DONE


        lottos.map outer@{
            val data = calculateLotto(it.numbers, winningNumbers.numbers, bonusNumber.number)
            updateLottoResults(data)
        }
        println(result)
        outputView.printWinnigResults(result)
    }

    private fun updateLottoResults(data: Pair<Int, Int>) {
        if (data.first == 5) {
            val key = data.first * 10 + data.second
            result[key] = result.getOrDefault(key, 0) + 1
            return
        }
        if (data.first in 0..2) {
            return
        }
        result[data.first] = result.getOrDefault(data.first, 0) + 1
    }

    private fun calculateLotto(
        lottoNumbers: List<LottoNumber>,
        winningnumbers: List<LottoNumber>,
        bonusNumber: LottoNumber
    ): Pair<Int, Int> {
        var winningMatch = 0
        val bonusMatch = lottoNumbers.count { it == bonusNumber }

        for (num in lottoNumbers) {
            if (winningnumbers.contains(num)) {
                winningMatch += 1
            }
        }
        return Pair(winningMatch, bonusMatch)
    }
}