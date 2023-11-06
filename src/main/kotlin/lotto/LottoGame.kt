package lotto

import lotto.LottoGameState.*
import lotto.LottoGameManagerState.*

class LottoGame {
    private var gameState = BUYING
    private val gameManager = LottoGameManager()
    private val gameViewer = LottoGameViewer()

    fun run() {
        while (gameState != FINISHED) {
            gameManager.set(gameState)
            gameViewer.set(gameState, gameManager.getState(), gameManager.getData())
            if (gameManager.getState() == NORMAL) updateState()
        }
    }

    private fun updateState() {
        when (gameState) {
            BUYING -> gameState = PICKING_WINNING
            PICKING_WINNING -> gameState = PICKING_BONUS
            PICKING_BONUS -> gameState = WINNING
            WINNING -> gameState = FINISHED
            FINISHED -> {}
        }
    }
}