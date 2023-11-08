package lotto

import lotto.ErrorMessage.ERROR_BONUS_DUPLICATED
import lotto.ErrorMessage.ERROR_INPUT_N0T_NUM
import lotto.ErrorMessage.ERROR_INPUT_NUMBER_NO_FORMAT
import lotto.ErrorMessage.ERROR_INPUT_PURCHASE_PRICE
import lotto.ErrorMessage.ERROR_LIST_SIZE_OUT_OF_RANGE
import lotto.ErrorMessage.ERROR_LOW_PRICE
import lotto.ErrorMessage.ERROR_NUMBER_DUPLICATED
import lotto.ErrorMessage.ERROR_NUMBER_OUT_OF_RANGE

object Validation {
    private const val MOD_UNIT = 1000

    fun validatePurchasePrice(purchasePrice: String) {
        validateInputAbleToConvertToInt(purchasePrice)
        validateAmount(purchasePrice)
        validatePriceRange(purchasePrice)
    }

    fun validateLottoNumber(lottoNumber: String) {
        val numbers = lottoNumber.split(",")
        validateIsNumber(numbers)
        validateInRange(numbers)
        validateListSize(numbers)
        validateDuplicate(numbers)
    }

    fun validateBonusNumber(bonusNumber: String) {
        validateNumberRange(bonusNumber)
        validateBonusNumberDuplicated(bonusNumber)
    }

    private fun validateInputAbleToConvertToInt(price: String) {
        when (price.toIntOrNull()) {
            is Int -> {}
            else -> throw IllegalArgumentException(ERROR_INPUT_N0T_NUM)
        }
    }

    private fun validateAmount(price: String) {
        if (price.toInt() < MOD_UNIT)
            throw IllegalArgumentException(ERROR_LOW_PRICE)
    }

    private fun validatePriceRange(price: String) {
        if (price.toInt() % MOD_UNIT != 0)
            throw IllegalArgumentException(ERROR_INPUT_PURCHASE_PRICE)
    }

    private fun validateDuplicate(lottoList: List<String>) {
        if (lottoList.size != lottoList.distinct().size)
            throw IllegalArgumentException(ERROR_NUMBER_DUPLICATED)
    }

    private fun validateInRange(lottoList: List<String>) {
        for (number in lottoList) {
            validateNumberRange(number)
        }
    }

    private fun validateListSize(lottoList: List<String>) {
        if (lottoList.size != 6)
            throw IllegalArgumentException(ERROR_LIST_SIZE_OUT_OF_RANGE)
    }

    private fun validateIsNumber(lottoList: List<String>) {
        for (number in lottoList) {
            when (number.toIntOrNull()) {
                is Int -> {}
                else -> throw IllegalArgumentException(ERROR_INPUT_NUMBER_NO_FORMAT)
            }
        }
    }

    private fun validateNumberRange(number: String) {
        when (number.toInt()) {
            in (1..45) -> {}
            else -> {
                throw IllegalArgumentException(ERROR_NUMBER_OUT_OF_RANGE)
            }
        }
    }

    private fun validateBonusNumberDuplicated(number: String) {
        if (LottoData.myLottoNumber.contains(number.toInt()))
            throw IllegalArgumentException(ERROR_BONUS_DUPLICATED)
    }
}