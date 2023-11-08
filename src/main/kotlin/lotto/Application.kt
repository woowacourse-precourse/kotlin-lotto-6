package lotto

import lotto.io.UserInterface

fun main() {
    val ui = UserInterface()
    val inputMoney = MoneyInput(ui)
    val winningLottoMaker = WinningLottoMaker(ui)
    val lottoMachine = LottoMachineInitializer(inputMoney, winningLottoMaker).setLottoMachine()

    lottoMachine.playLotto()
}
