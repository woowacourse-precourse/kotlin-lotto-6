package lotto.model.validator

import lotto.model.LottoNumber

class LottoValidator : Validator<List<LottoNumber>> {

    override fun validate(data: List<LottoNumber>) {
        validateSize(data)
        validateDuplicatedNumber(data)
    }

    private fun validateSize(numbers: List<LottoNumber>) {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INVALID_SIZE_ERROR }
    }

    private fun validateDuplicatedNumber(numbers: List<LottoNumber>) {
        require(numbers.toSet().size == numbers.size) { DUPLICATED_NUMBER_ERROR }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val INVALID_SIZE_ERROR = "로또 값이 6개가 아닙니다."
        private const val DUPLICATED_NUMBER_ERROR = "동일한 숫자는 값으로 입력할 수 없습니다. 로또 값이 중복되지 않았는지 확인해주세요."
    }
}