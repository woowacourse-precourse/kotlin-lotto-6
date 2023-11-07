package lotto

import lotto.LottoGameState.*
import lotto.LottoGameManagerState.*
import camp.nextstep.edu.missionutils.Console

class LottoGameManager {
    private var gameState = BUYING
    private var gameManagerState = READY
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
            BUYING -> buyingProcess()
            PICKING_WINNING -> pickingWinningProcess()
            PICKING_BONUS -> pickingBonusProcess()
            WINNING -> winningProcess()
            FINISHED -> {}
        }
    }

    private fun buyingProcess() {
        when (gameManagerState) {
            READY, REQUEST_ERROR -> gameManagerState = REQUEST
            REQUEST -> buyLotto()
            RESULT -> gameManagerState = READY
        }
    }

    private fun pickingWinningProcess() {
        when (gameManagerState) {
            READY, REQUEST_ERROR -> gameManagerState = REQUEST
            REQUEST -> pickWinningNumbers()
            RESULT -> {}
        }
    }

    private fun pickingBonusProcess() {
        when (gameManagerState) {
            READY, REQUEST_ERROR -> gameManagerState = REQUEST
            REQUEST -> pickBonusNumber()
            RESULT -> {}
        }
    }

    private fun winningProcess() {
        when (gameManagerState) {
            READY -> setWinningResult()
            else -> {}
        }
    }

    private fun buyLotto() {
        getMoneyFromUser()
        if (!isGameManagerOnError()) {
            generateLottoAsMuchAsMoney()
            whenGameManagerOnResult(userLotteryTickets)
        }
    }

    private fun getMoneyFromUser() {
        val input = Console.readLine()

        try {
            userMoney = validatedNumberAsMoney(input)
        } catch (e: IllegalArgumentException) {
            whenGameManagerOnRequestError(e)
        }
    }

    private fun generateLottoAsMuchAsMoney() {
        val userLotteryTickets = mutableListOf<Lotto>()
        val count = userMoney / 1000

        for (i in 1..count) {
            userLotteryTickets.add(lottoGenerator.get())
        }

        this.userLotteryTickets = userLotteryTickets
    }

    private fun pickWinningNumbers() {
        getWinningNumbersFromUser()
        if (!isGameManagerOnError()) gameManagerState = READY
    }

    private fun getWinningNumbersFromUser() {
        val input = Console.readLine()

        try {
            winningNumbers = validatedNumbersAsWinning(input)
        } catch (e: IllegalArgumentException) {
            whenGameManagerOnRequestError(e)
        }
    }

    private fun pickBonusNumber() {
        getBonusNumberFromUser()
        if (!isGameManagerOnError()) gameManagerState = READY
    }

    private fun getBonusNumberFromUser() {
        val input = Console.readLine()

        try {
            bonusNumber = validatedNumberAsBonus(input)
        } catch (e: IllegalArgumentException) {
            whenGameManagerOnRequestError(e)
        }
    }

    private fun setWinningResult() {

    }

    private fun validatedNumberAsMoney(input: String): Int {
        InputValidator.checkIsNotBlank(input)
        InputValidator.checkIsDigit(input)
        InputValidator.checkDividedAsThousand(input)
        InputValidator.checkIsOverZero(input)

        return input.toInt()
    }

    private fun validatedNumbersAsWinning(input: String): List<Int> {
        InputValidator.checkIsNotBlank(input)
        InputValidator.checkHasSeparator(input, Constants.COMMA)
        input.split(Constants.COMMA).map { validateAsLottoNumber(it) }
        InputValidator.checkCountsOf(input.split(Constants.COMMA), Constants.LOTTO_NUMBER_COUNT)

        return input.split(Constants.COMMA).map { it.toInt() }
    }

    private fun validatedNumberAsBonus(input: String): Int {
        InputValidator.checkIsNotBlank(input)
        validateAsLottoNumber(input)
        InputValidator.checkIsNotContained(input.toInt(), winningNumbers)

        return input.toInt()
    }

    private fun validateAsLottoNumber(input: String) {
        InputValidator.checkIsDigit(input)
        InputValidator.checkIsInBoundary(
            Integer.valueOf(input),
            Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER
        )
    }

    private fun isGameManagerOnError() = gameManagerState == REQUEST_ERROR

    private fun whenGameManagerOnRequestError(error: IllegalArgumentException) {
        data = error
        gameManagerState = REQUEST_ERROR
    }

    private fun whenGameManagerOnResult(data: Any) {
        this.data = data
        gameManagerState = RESULT
    }
}