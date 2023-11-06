package lotto

import PlayLotto
import lotto.domain.WinningNumber
import lotto.model.PlayLottoState

fun main() {
    val winningNumber = WinningNumber()
    val lottoData = PlayLottoState.LottoData()
    PlayLotto(winningNumber, lottoData).start()
}
