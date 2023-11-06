package lotto

import lotto.LottoGameState.*
import lotto.LottoGameManagerState.*
import java.lang.IllegalArgumentException

class LottoGameViewer {
    private var gameState = BUYING
    private var gameManagerState = READY

    fun set(gameState: LottoGameState, gameManagerState: LottoGameManagerState, data: Any) {
        this.gameState = gameState
        this.gameManagerState = gameManagerState

        commandByManagerState(data)
    }

    private fun commandByManagerState(data: Any) {
        if (gameManagerState == REQUEST) printRequestMessageByGameState()
        if (gameManagerState == REQUEST_ERROR) printError(data)
        if (gameManagerState == RESULT) printDataByGameState(data)
    }

    private fun printRequestMessageByGameState() {
        if (gameState == BUYING) println(Constants.REQUEST_BUYING_MESSAGE)
        if (gameState == PICKING_WINNING) println(Constants.REQUEST_PICKING_WINNING_MESSAGE)
        if (gameState == PICKING_BONUS) println(Constants.REQUEST_PICKING_BONUS_MESSAGE)
    }

    private fun printError(data: Any) {
        val error = data as IllegalArgumentException

        println(Constants.ERROR + error.message)
    }

    private fun printDataByGameState(data: Any) {
        if (gameState == BUYING) printResultOfBuyingLotto(data)
        if (gameState == WINNING) printResultOfWinning(data)
    }

    private fun printResultOfBuyingLotto(data: Any) {
        val userLotteryTickets = data as List<Lotto>

        println("${userLotteryTickets.size}" + Constants.RESULT_BUYING_COUNT_MESSAGE)
        userLotteryTickets.map { println(it.getNumbers().sorted()) }
    }

    private fun printResultOfWinning(data: Any) {

    }
}