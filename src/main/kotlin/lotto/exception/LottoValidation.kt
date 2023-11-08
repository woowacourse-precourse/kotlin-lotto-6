package lotto.exception

class LottoValidation(private val lotto: String) {
    private val input: List<String> = lotto.split(",")

    init {
        validateLottoComma()
        validateLottoRange()
        validateLottoNumber()
        validateLottoDuplication()
    }

    private fun validateLottoComma() {
        require(lotto.contains(",")) {
            ErrorConstants.INVALID_LOTTO_FORMAT_ERROR
        }
    }

    private fun validateLottoRange() {
        repeat(input.size) {
            require(input[it].toInt() in 1..45) {
                ErrorConstants.INVALID_LOTTO_RANGE_ERROR
            }
        }
    }

    private fun validateLottoNumber() {
        repeat(input.size) {
            try {
                input[it].toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(ErrorConstants.INVALID_PRICE_FORMAT_ERROR)
            }
        }
    }

    private fun validateLottoDuplication() {
        require(input.toSet().size == input.size) {
            ErrorConstants.DUPLICATE_LOTTO_ERROR
        }
    }
}