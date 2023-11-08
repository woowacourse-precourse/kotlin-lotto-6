package lotto.model.validation

import lotto.model.Lotto
import lotto.model.LottoNumbersFactory

class LottoNumValidation {
    fun validateLottoNum(input: List<Int>) {
        checkLottoNumSize(input)
        checkForDuplicateLottoNumbers(input)
        checkLottoNumRange(input)
    }

    fun validateBonusLottoNum(winningLottoNum: Lotto, input: Int) {
        checkLottoNumRange(mutableListOf(input))
        checkForDuplicateBonusNumbers(winningLottoNum, input)
    }

    private fun checkLottoNumSize(input: List<Int>) {
        require(input.size == 6) { LOTTO_NUM_SIZE_ERROR }
    }

    private fun checkForDuplicateLottoNumbers(input: List<Int>) {
        require(input.size == input.distinct().count()) { DUPLICATE_LOTTO_NUM_ERROR }
    }

    private fun checkLottoNumRange(input: List<Int>) {
        require(input.all { it in LottoNumbersFactory.LOTTO_START_NUM..LottoNumbersFactory.LOTTO_LAST_NUM }) { LOTTO_NUM_RANGE_ERROR }
    }

    private fun checkForDuplicateBonusNumbers(input: Lotto, bonusNum: Int) {
        require(!(bonusNum in input.getLottoNumbers())) { DUPLICATE_BONUS_NUM_ERROR }
    }

    companion object {
        const val LOTTO_NUM_SIZE_ERROR = "[ERROR] 로또 번호의 숫자의 개수는 6개 입니다."
        const val DUPLICATE_LOTTO_NUM_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다."
        const val LOTTO_NUM_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자만 입력할 수 있습니다."
        const val DUPLICATE_BONUS_NUM_ERROR = "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."
    }
}