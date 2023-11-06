package lotto.util

import lotto.util.Constants.DELIMITER
import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.LOTTO_PRICE
import lotto.util.Constants.LOTTO_SIZE

object Validator {
    fun validateInteger(input: String) {
        require(input.toIntOrNull() != null) { LottoException.INVALID_INTEGER.getMessage() }
    }

    fun validateRange(input: Int) {
        require(input in LOTTO_PRICE..Int.MAX_VALUE) { LottoException.INVALID_RANGE.getMessage() }
    }

    fun validate1000Unit(input: Int) {
        require(input % LOTTO_PRICE == 0) { LottoException.INVALID_1000_UNIT.getMessage() }
    }

    fun validateLottoInteger(input: String) {
        val validation = input.split(DELIMITER)
        validation.forEach {
            validateInteger(it)
        }
    }

    fun validateLottoRange(input: List<Int>) {
        input.forEach {
            validateNumberRange(it)
        }
    }

    fun validateLottoLength(input: List<Int>) {
        require(input.size == LOTTO_SIZE) { LottoException.INVALID_LOTTO_LENGTH.getMessage() }
    }

    fun validateLottoUnique(input: List<Int>) {
        require(input.distinct().size == LOTTO_SIZE) { LottoException.INVALID_LOTTO_UNIQUE.getMessage() }
    }

    fun validateNumberRange(input: Int) {
        require(input in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) { LottoException.INVALID_LOTTO_RANGE.getMessage() }
    }

    fun validateNotNull(input: String) {
        require(input.trim().isNotEmpty()) { LottoException.INVALID_NOT_NULL.getMessage() }
    }

    fun validateContain(numbers: List<Int>, validation: Int) {
        require(!numbers.contains(validation)) { LottoException.DUPLICATED_NUMBER.getMessage() }
    }
}