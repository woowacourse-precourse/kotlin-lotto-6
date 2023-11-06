package lotto

import lotto.LottoGameState.*
import lotto.LottoGameManagerState.*

class LottoGame {
    private var gameState = BUYING
    private val gameManager = LottoGameManager()
    private val gameViewer = LottoGameViewer()

    fun run() {
        while (gameState != FINISHED) {
            setGameState()
            if (isGameManagerOnReady()) updateGameState()
        }
    }

    private fun setGameState() {
        val gameManagerState = gameManager.getState()
        val stateData = gameManager.getData()

        gameManager.set(gameState)
        gameViewer.set(gameState, gameManagerState, stateData)
    }

    private fun updateGameState() {
        when (gameState) {
            BUYING -> gameState = PICKING_WINNING
            PICKING_WINNING -> gameState = PICKING_BONUS
            PICKING_BONUS -> gameState = WINNING
            WINNING -> gameState = FINISHED
            FINISHED -> {}
        }
    }

    private fun isGameManagerOnReady() = gameManager.getState() == READY
}