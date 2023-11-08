package validator.lottonumbervalidator

import view.OutputView

object LottoNumberValidator {
    private const val LOTTO_IS_NUMBER = "로또 번호는 숫자여야 합니다."
    private const val LOTTO_SIZE_IS_SIX = "로또 번호는 서로 다른 숫자 6개여야 합니다."
    private const val LOTTO_NUMBER_RANGE = "로또 번호의 숫자 범위는 1~45여야 합니다."
    private const val MINIMUM_LOTTO_NUMBER = 1
    private const val MAXIMUM_LOTTO_NUMBER = 45
    private const val LOTTO_SIZE = 6

    fun isAppropriateLottoNumber(input: String) {
        val lottoNumbers = input.split(",")

        require(lottoNumbers.distinct().size == LOTTO_SIZE) { OutputView.error(LOTTO_SIZE_IS_SIX) }

        for (lottoNumber in lottoNumbers) {
            val number = lottoNumber.toIntOrNull()
            requireNotNull(number) { OutputView.error(LOTTO_IS_NUMBER) }
            require(number in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) { OutputView.error(LOTTO_NUMBER_RANGE) }
        }
    }
}