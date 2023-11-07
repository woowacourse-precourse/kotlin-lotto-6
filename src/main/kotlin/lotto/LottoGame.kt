package lotto

import lotto.LottoGameState.*
import lotto.LottoGameManagerState.*

class LottoGame {
    private var gameState = LottoGameState.values().first()
    private val gameManager = LottoGameManager()
    private val gameViewer = LottoGameViewer()

    fun run() {
        while (isGameNotFinished()) {
            setGameState()
            if (isGameManagerOnReady()) nextGameState()
        }
    }

    private fun setGameState() {
        gameManager.set(gameState)
        gameViewer.set(gameState, gameManager.getState(), gameManager.getData())
    }

    private fun nextGameState() {
        val index = LottoGameState.values().indexOf(gameState)

        gameState = LottoGameState.values()[index + 1]
    }

    private fun isGameNotFinished() = gameState != FINISHED
    private fun isGameManagerOnReady() = gameManager.getState() == READY
}