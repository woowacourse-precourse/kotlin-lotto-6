package lotto

import lotto.LottoGameState.*

class LottoGame {
    private var gameState = BUYING
    private val gameManager = LottoGameManager()
    private val gameViewer = LottoGameViewer()

    fun run() {
        while (gameState != FINISHED) {
            gameManager.set(gameState)
            gameViewer.set(gameState, gameManager.getViewerState())
            updateGameState()
        }
    }

    private fun updateGameState() {
        when (gameState) {
            BUYING -> gameState = PICKING
            PICKING -> gameState = WINNING
            WINNING -> gameState = FINISHED
            FINISHED -> {}
        }
    }
}