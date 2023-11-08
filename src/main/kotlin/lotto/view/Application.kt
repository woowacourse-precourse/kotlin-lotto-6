package lotto.view

import lotto.controller.GameController

fun main() {
    GameController.apply {
        startGame()
        settingWinningNumbers()
        matchWinningLotto()
        endGame()
    }
}