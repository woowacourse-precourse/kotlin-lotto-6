package lotto

import ui.InputManager
import ui.OutputManager

fun main() {
    val test = InputManager().inputJackpotNumbers { OutputManager().invalidLottoNumbers() }
}
