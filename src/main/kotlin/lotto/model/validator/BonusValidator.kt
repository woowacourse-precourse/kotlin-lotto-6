package lotto.model.validator

import lotto.model.Lotto
import lotto.model.LottoNumber

class BonusValidator : Validator<BonusValidation> {

    override fun validate(data: BonusValidation) {
        validDuplicatedWinningNumbers(data.winningNumbers, data.bonusNumber)
    }

    private fun validDuplicatedWinningNumbers(winningNumbers: Lotto, bonusNumber: LottoNumber) {
        require(!winningNumbers.isMatchedBonus(bonusNumber)) { DUPLICATED_WINNING_NUMBERS_ERROR }
    }

    companion object {
        internal const val DUPLICATED_WINNING_NUMBERS_ERROR = "당첨 번호에 이미 존재하는 값입니다. 다른 보너스 번호를 입력해주세요."
    }
}

data class BonusValidation(val winningNumbers: Lotto, val bonusNumber: LottoNumber)