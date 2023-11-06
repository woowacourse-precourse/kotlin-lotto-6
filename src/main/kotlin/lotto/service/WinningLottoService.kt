package lotto.service

import lotto.domain.WinningLotto

class WinningLottoService(
) {

    private var winningNumbers = listOf<Int>()
    private var bonusNumber = 0
    fun makeWinningLotto() = WinningLotto(winningNumbers,bonusNumber)
    fun setWinningNumbers(winningNumbers: List<Int>){
        this.winningNumbers = winningNumbers
    }
    fun setBonusNumber(bonusNumber : Int){
        this.bonusNumber = bonusNumber
    }
}