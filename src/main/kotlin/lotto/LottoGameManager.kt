package lotto

import lotto.state.LottoGameState.*
import lotto.state.LottoGameManagerState.*
import lotto.state.LottoGameState
import lotto.state.LottoGameManagerState
import camp.nextstep.edu.missionutils.Console
import lotto.data.Lotto
import lotto.data.Money
import lotto.data.WinningResult
import lotto.data.Winning
import java.util.*

class LottoGameManager {
    private var gameState = LottoGameState.values().first()
    private var gameManagerState = LottoGameManagerState.values().first()
    private val lottoGenerator = LottoGenerator()
    private val winningResultGenerator = WinningResultGenerator()
    private var data: Any = ""
    private var userLotteryTickets = listOf<Lotto>()
    private var winningNumbers = listOf<Int>()
    private lateinit var money: Money
    private lateinit var winning: Winning

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
            REQUEST, REQUEST_ERROR -> {}
            RESULT -> gameManagerState = READY
        }
    }

    private fun buyLotto() {
        getMoneyFromUser()
        if (isGameManagerNotOnError()) {
            generateLottoAsMuchAsMoney()
            whenGameManagerOnResult(userLotteryTickets)
        }
    }

    private fun getMoneyFromUser() {
        val input = Console.readLine()

        try {
            money = Money(validatedAsNumber(input))
        } catch (e: IllegalArgumentException) {
            whenGameManagerOnRequestError(e)
        }
    }

    private fun generateLottoAsMuchAsMoney() {
        val userLotteryTickets = mutableListOf<Lotto>()
        val count = money.number / Constants.THOUSAND

        for (i in Constants.ZERO until count) {
            userLotteryTickets.add(lottoGenerator.get())
        }

        this.userLotteryTickets = userLotteryTickets
    }

    private fun pickWinningNumbers() {
        getWinningNumbersFromUser()
        if (isGameManagerNotOnError()) gameManagerState = READY
    }

    private fun getWinningNumbersFromUser() {
        val input = Console.readLine()

        try {
            winningNumbers = validatedAsWinningNumbers(input)
        } catch (e: IllegalArgumentException) {
            whenGameManagerOnRequestError(e)
        }
    }

    private fun pickBonusNumber() {
        getBonusNumberFromUser()
        if (isGameManagerNotOnError()) gameManagerState = READY
    }

    private fun getBonusNumberFromUser() {
        val input = Console.readLine()

        try {
            winning = Winning(winningNumbers, validatedAsNumber(input))
        } catch (e: IllegalArgumentException) {
            whenGameManagerOnRequestError(e)
        }
    }

    private fun setWinningResult() {
        val result = winningResultGenerator.get(userLotteryTickets, winning, money)
        whenGameManagerOnResult(result)
    }

    /**
     * 당첨 번호 유효성 검사
     *
     * 당첨 번호는 기존 로또의 형태와 동일하므로, 로또 객체 생성을 통해 유효성을 검사한다.
     */
    private fun validatedAsWinningNumbers(input: String): List<Int> {
        val numbers = validatedAsNumbers(input)
        Lotto(numbers)

        return numbers
    }

    private fun validatedAsNumbers(input: String): List<Int> {
        InputValidator.checkIsNotBlank(input)
        InputValidator.checkHasCommaSeparator(input)
        input.split(Constants.COMMA).map { InputValidator.checkIsDigit(it) }

        return input.split(Constants.COMMA).map { it.toInt() }
    }

    private fun validatedAsNumber(input: String): Int {
        InputValidator.checkIsNotBlank(input)
        InputValidator.checkIsDigit(input)

        return input.toInt()
    }

    private fun isGameManagerNotOnError() = gameManagerState != REQUEST_ERROR

    private fun whenGameManagerOnRequestError(error: IllegalArgumentException) {
        data = error
        gameManagerState = REQUEST_ERROR
    }

    private fun whenGameManagerOnResult(data: Any) {
        this.data = data
        gameManagerState = RESULT
    }
}