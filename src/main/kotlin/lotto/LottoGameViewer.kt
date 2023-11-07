package lotto

import lotto.state.LottoGameState.*
import lotto.state.LottoGameManagerState.*
import lotto.data.Lotto
import lotto.state.LottoGameManagerState
import lotto.state.LottoGameState

class LottoGameViewer {
    private var gameState = LottoGameState.values().first()
    private var gameManagerState = LottoGameManagerState.values().first()
    private var data: Any = ""

    fun set(gameState: LottoGameState, gameManagerState: LottoGameManagerState, data: Any) {
        this.gameState = gameState
        this.gameManagerState = gameManagerState
        this.data = data

        commandByManagerState()
    }

    private fun commandByManagerState() {
        if (gameManagerState == REQUEST) printRequestMessageByGameState()
        if (gameManagerState == REQUEST_ERROR) printError()
        if (gameManagerState == RESULT) printResultDataByGameState()
    }

    private fun printRequestMessageByGameState() {
        if (gameState == BUYING) println(Constants.REQUEST_BUYING_MESSAGE)
        if (gameState == PICKING_WINNING) println(Constants.REQUEST_PICKING_WINNING_MESSAGE)
        if (gameState == PICKING_BONUS) println(Constants.REQUEST_PICKING_BONUS_MESSAGE)
    }

    private fun printError() {
        val error = data as IllegalArgumentException

        println(Constants.ERROR + error.message)
    }

    private fun printResultDataByGameState() {
        if (gameState == BUYING) printResultOfBuyingLotto()
        if (gameState == WINNING) printResultOfWinning()
    }

    private fun printResultOfBuyingLotto() {
        val userLotteryTickets = data as List<Lotto>

        println("${userLotteryTickets.size}" + Constants.RESULT_BUYING_COUNT_MESSAGE)
        userLotteryTickets.map { println(it.getNumbers().sorted()) }
    }

    private fun printResultOfWinning() {

    }
}