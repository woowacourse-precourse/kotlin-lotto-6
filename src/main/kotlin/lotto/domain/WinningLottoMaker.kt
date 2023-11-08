package lotto.domain

import lotto.io.UserInterface
import lotto.model.Lotto
import lotto.model.WinningLotto

class WinningLottoMaker(private val ui: UserInterface) {

    fun setWinningLotto(): WinningLotto {
        val winnerNumbers = ui.askWinningNumbers()
        val bonusNumber = ui.askBonusNumber(winnerNumbers)

        return WinningLotto(Lotto(winnerNumbers), bonusNumber)
    }
}