package lotto

import lotto.data.LottoData
import lotto.domain.WinningNumber

fun main() {
    val winningNumber = WinningNumber
    val lottoData = LottoData()
    PlayLotto(winningNumber, lottoData).start()
}
