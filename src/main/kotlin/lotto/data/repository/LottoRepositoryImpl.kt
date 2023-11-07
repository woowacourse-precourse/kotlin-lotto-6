package lotto.data.repository

import lotto.data.model.LottoWinningNumber
import lotto.data.model.UserLottoState
import lotto.ui.repository.LottoRepository
import lotto.utils.GameUtils

class LottoRepositoryImpl : LottoRepository {
    private var userLottoState = UserLottoState(emptyList())

    override fun generateRandomLotto(amount: Int) : UserLottoState {
        userLottoState.lottoTickets = GameUtils.generateLotto(amount)
        return userLottoState
    }

    override fun checkStatistics(lottoWinningNumber: LottoWinningNumber): UserLottoState {
        userLottoState = GameUtils.totalStatistics(userLottoState,lottoWinningNumber)
        return userLottoState
    }
}