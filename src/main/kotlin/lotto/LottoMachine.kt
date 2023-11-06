package lotto

import lotto.io.UserInterface

class LottoMachine(
    private val user: User,
    private val winningLotto: WinningLotto,
) {
    fun calculateMyResult() {
        user.compareToWinningLotto(winningLotto.numbers, winningLotto.bonusNumber)
    }

}