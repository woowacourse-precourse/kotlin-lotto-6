package lotto

import lotto.domain.WinningNumber

fun main() {
    val winningNumber = WinningNumber
    PlayLotto(winningNumber).start()
}
