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
        if (gameState == BUYING) gameState = PICKING
        if (gameState == PICKING) gameState = WINNING
        if (gameState == WINNING) gameState = FINISHED
    }
}