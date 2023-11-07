package lotto

import ui.GameConsole
import ui.UserInputReader

fun main() {
    val lottoGame = LottoGame(UserInputReader(), LottoMachine(), GameConsole(), LottoResultChecker())
    lottoGame.startGame()
}
