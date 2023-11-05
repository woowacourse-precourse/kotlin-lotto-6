package lotto

import lotto.domain.WinningNumber

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun compareNumber(winningNumber: WinningNumber) {}

    fun printLottoNumber() {}

    fun printResultOfLotto() {}
}
