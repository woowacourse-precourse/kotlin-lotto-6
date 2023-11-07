package lotto.domain

import lotto.util.Error

class WinningLotto(lottoNumber: Lotto, bonusNumber: Int) {
    init {
        require(bonusNumber in 1..45) { Error.InvalidLottoNumber.message }
        require(!lottoNumber.isDuplicated(bonusNumber)) { Error.InvalidBonusNumber.message }
    }
}