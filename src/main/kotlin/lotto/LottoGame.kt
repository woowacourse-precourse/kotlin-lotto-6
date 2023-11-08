package lotto

import lotto.state.LottoGameState.*
import lotto.state.LottoGameManagerState.*
import lotto.state.LottoGameState

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
        var index = LottoGameState.values().indexOf(gameState)

        gameState = LottoGameState.values()[++index]
    }

    private fun isGameNotFinished() = gameState != FINISHED
    private fun isGameManagerOnReady() = gameManager.getState() == READY
}