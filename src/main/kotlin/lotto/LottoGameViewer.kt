package lotto

import lotto.LottoGameState.*
import lotto.LottoGameManagerState.*
import java.lang.IllegalArgumentException

class LottoGameViewer {
    private var gameState = BUYING
    private var gameManagerState = NORMAL

    fun set(gameState: LottoGameState, gameManagerState: LottoGameManagerState, data: Any) {
        this.gameState = gameState
        this.gameManagerState = gameManagerState

        commandByManagerState(data)
    }

    private fun commandByManagerState(data: Any) {
        when (gameManagerState) {
            REQUEST -> printRequestMessageByGameState()
            REQUEST_ERROR -> printError(data)
            RESULT -> printDataByGameState(data)
            NORMAL -> {}
        }
    }

    private fun printRequestMessageByGameState() {
        when (gameState) {
            BUYING -> println(Constants.REQUEST_BUYING_MESSAGE)
            PICKING_WINNING -> println(Constants.REQUEST_PICKING_WINNING_MESSAGE)
            PICKING_BONUS -> println(Constants.REQUEST_PICKING_BONUS_MESSAGE)
            else -> {}
        }
        // TODO: 나머지 state 구현
    }

    private fun printError(data: Any) {
        val error = data as IllegalArgumentException

        println(Constants.ERROR + error.message)
    }

    private fun printDataByGameState(data: Any) {
        if (gameState == BUYING) printResultOfBuyingLotto(data)
        // TODO: 나머지 state 구현
    }

    private fun printResultOfBuyingLotto(data: Any) {
        val userLotteryTickets = data as List<Lotto>

        println("${userLotteryTickets.size}" + Constants.RESULT_BUYING_COUNT_MESSAGE)
        userLotteryTickets.map { println(it.getNumbers().sorted()) }
    }
}