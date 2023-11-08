package lotto.domain

import lotto.domain.lotto.Lotto
import lotto.domain.lotto.LottoResult
import lotto.util.Error

class WinningLotto(private val lottoNumber: Lotto, private val bonusNumber: Int) {

    init {
        require(bonusNumber in 1..45) { Error.InvalidLottoNumber.message }
        require(!lottoNumber.isDuplicated(bonusNumber)) { Error.InvalidBonusNumber.message }
    }

    fun checkWinning(lotto: Lotto): LottoResult =
        LottoResult.valueOf(lottoNumber.compareTo(lotto), lotto.hasNumber(bonusNumber))
}