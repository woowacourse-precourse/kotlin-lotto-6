package lotto

import lotto.io.UserInterface

class WinningLottoMaker(private val ui: UserInterface) {

    fun setWinningLotto(): WinningLotto {
        val winnerNumbers = ui.askWinningNumbers()
        val bonusNumber = ui.askBonusNumber(winnerNumbers)

        return WinningLotto(Lotto(winnerNumbers), bonusNumber)
    }
}