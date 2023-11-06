package lotto.domain

import lotto.domain.model.Lotto
import lotto.util.Constants

class WinningLotto(private val winningNumbers: Lotto, private val bonusNumber: Int) {
    init {
        require(bonusNumber in Constants.LOTTO_START_NUM..Constants.LOTTO_END_NUM) {
            BONUS_NUM_RANGE_ERROR
        }
        require(!winningNumbers.contains(bonusNumber)) {
            BONUS_NUM_DUPLICATE_ERROR
        }
    }

    companion object {
        private const val BONUS_NUM_RANGE_ERROR =
            "[ERROR] 보너스 숫자는 ${Constants.LOTTO_START_NUM}~${Constants.LOTTO_END_NUM}사이의 숫자여야 합니다."
        private const val BONUS_NUM_DUPLICATE_ERROR = "[ERROR] 보너스 숫자는 기존 당첨 번호와 중복되서는 안됩니다."
    }
}
