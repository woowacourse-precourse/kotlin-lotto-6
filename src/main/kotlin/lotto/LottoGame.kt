package lotto

import lotto.LottoGameState.*

class LottoGame {
    private var gameState: LottoGameState = INITIALIZED

    fun run() {
        while (gameState != FINISHED) {
            commandByGameState()
        }
    }
    
    private fun commandByGameState() {
        when (gameState) {
            INITIALIZED -> {
                print("initialized")
                gameState = PURCHASING
            }
            PURCHASING -> {
                print("purchasing")
                gameState = DRAWING
            }
            DRAWING -> {
                print("drawing")
                gameState = WINNING
            }
            WINNING -> {
                print("winning")
                gameState = FINISHED
            }
            else -> {}
        }
    }
}