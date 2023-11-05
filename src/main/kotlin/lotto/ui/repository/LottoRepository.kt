package lotto.ui.repository

import lotto.data.model.LottoWinningNumber
import lotto.data.model.UserLottoState

interface LottoRepository {
    fun generateRandomLotto(amount: Int) : UserLottoState
    fun checkStatistics(lottoWinningNumber: LottoWinningNumber) : UserLottoState
}