package lotto.domain.lotto

import lotto.exception.WinningLottoException

class WinningLotto(
    val winningNumbers: Lotto,
    val bonusNumber: LottoNumber
) {
    init {
        require(!winningNumbers.isContainLottoNumber(bonusNumber)) {
            WinningLottoException.BONUS_NUMBER_DUPLICATED.message
        }
    }
}