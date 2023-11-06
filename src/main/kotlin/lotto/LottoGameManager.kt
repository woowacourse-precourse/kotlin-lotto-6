package lotto

import lotto.LottoGameState.*
import lotto.LottoGameManagerState.*
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class LottoGameManager {
    private var gameState = BUYING
    private var gameManagerState = NORMAL
    private val lottoGenerator = LottoGenerator()
    private var data: Any = ""
    private var userMoney = 0
    private var userLotteryTickets = listOf<Lotto>()
    private var winningNumbers = listOf<Int>()
    private var bonusNumber = 0


    fun getState() = this.gameManagerState

    fun getData() = this.data

    fun set(gameState: LottoGameState) {
        this.gameState = gameState

        commandByGameState()
    }

    private fun commandByGameState() {
        when (gameState) {
            BUYING -> commandBuyingState()
            PICKING_WINNING -> commandPickingWinningState()
            PICKING_BONUS -> commandPickingBonusState()
            else -> {}
        }
    }

    private fun commandBuyingState() {
        when (gameManagerState) {
            NORMAL, REQUEST_ERROR -> gameManagerState = REQUEST
            REQUEST -> buyLotto()
            RESULT -> gameManagerState = NORMAL
        }
    }

    private fun commandPickingWinningState() {
        when (gameManagerState) {
            NORMAL, REQUEST_ERROR -> gameManagerState = REQUEST
            REQUEST -> pickWinningNumbers()
            RESULT -> {}
        }
    }

    private fun commandPickingBonusState() {
        when (gameManagerState) {
            NORMAL, REQUEST_ERROR -> gameManagerState = REQUEST
            REQUEST -> pickBonusNumber()
            RESULT -> {}
        }
    }

    private fun buyLotto() {
        getMoneyFromUser()
        if (gameManagerState != REQUEST_ERROR) {
            generateLotto()
            data = userLotteryTickets
            gameManagerState = RESULT
        }
    }

    private fun getMoneyFromUser() {
        val input = Console.readLine()

        try {
            userMoney = validatedNumberAsMoney(input)
        } catch (e: IllegalArgumentException) {
            data = e
            gameManagerState = REQUEST_ERROR
        }
    }

    private fun generateLotto() {
        val userLotteryTickets = mutableListOf<Lotto>()
        val count = userMoney / 1000

        for (i in 1..count) {
            userLotteryTickets.add(lottoGenerator.get())
        }

        this.userLotteryTickets = userLotteryTickets
    }

    private fun pickWinningNumbers() {
        getWinningNumbersFromUser()
        if (gameManagerState != REQUEST_ERROR) gameManagerState = NORMAL
    }

    private fun getWinningNumbersFromUser() {
        val input = Console.readLine()

        try {
            winningNumbers = validatedNumbersAsWinning(input)
        } catch (e: IllegalArgumentException) {
            data = e
            gameManagerState = REQUEST_ERROR
        }
    }

    private fun pickBonusNumber() {
        getBonusNumberFromUser()
        if (gameManagerState != REQUEST_ERROR) gameManagerState = NORMAL
    }

    private fun getBonusNumberFromUser() {
        val input = Console.readLine()

        try {
            bonusNumber = validatedNumberAsBonus(input)
        } catch (e: IllegalArgumentException) {
            data = e
            gameManagerState = REQUEST_ERROR
        }
    }

    private fun validatedNumberAsMoney(input: String): Int {
        InputValidator.checkIsNotBlank(input)
        InputValidator.checkIsDigit(input)
        InputValidator.checkDividedAsThousand(input)
        InputValidator.checkIsOverZero(input)

        return input.toInt()
    }

    private fun validatedNumbersAsWinning(input: String): List<Int> {
        InputValidator.checkHasSeparator(input, Constants.COMMA)
        InputValidator.checkCountsOf(input.split(Constants.COMMA), Constants.LOTTO_NUMBER_COUNT)
        input.split(Constants.COMMA).map { validateAsLottoNumber(it) }

        return input.split(Constants.COMMA).map { it.toInt() }
    }

    private fun validatedNumberAsBonus(input: String): Int {
        validateAsLottoNumber(input)
        InputValidator.checkIsNotContained(input.toInt(), winningNumbers)

        return input.toInt()
    }

    private fun validateAsLottoNumber(input: String) {
        InputValidator.checkIsNotBlank(input)
        InputValidator.checkIsDigit(input)
        InputValidator.checkIsInBoundary(
            Integer.valueOf(input),
            Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER
        )
    }
}