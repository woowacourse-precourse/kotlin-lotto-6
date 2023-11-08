package lotto.domain

import lotto.model.User
import lotto.model.WinningLotto

class LottoMachineInitializer(
    private val moneyInput: MoneyInput,
    private val winningLottoMaker: WinningLottoMaker
) {

    fun setLottoMachine(): LottoMachine {
        val user = setUserInform()
        val winningLotto = setWinningLotto()
        return LottoMachine(user, winningLotto)
    }

    private fun setUserInform(): User {
        return moneyInput.setUserInform()
    }

    private fun setWinningLotto(): WinningLotto {
        return winningLottoMaker.setWinningLotto()
    }
}