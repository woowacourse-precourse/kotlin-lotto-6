package lotto

enum class InputErrorMessage(val errorMessage: String) {
    PURCHASE_AMOUNT_EMPTY("[ERROR] 구입금액을 입력해주세요."),
    PURCHASE_AMOUNT_TYPE("[ERROR] 정수를 입력해주세요."),
    PURCHASE_AMOUNT_VALUE("[ERROR] 1000원 이상의 금액을 입력해주세요."),
    PURCHASE_AMOUNT_UNIT("[ERROR] 1000원 단위로 입력해주세요."),
    LOTTO_NUMBER_EMPTY("[ERROR] 당첨 번호를 입력해 주세요."),
    LOTTO_NUMBER_TYPE("[ERROR] 정수를 입력해주세요."),
    LOTTO_NUMBER_SIZE("[ERROR] 6개의 번호를 입력해주세요."),
    LOTTO_NUMBER_RANGE("[ERROR] 1에서 45사이의 정수를 입력해주세요."),
    LOTTO_NUMBER_REPEAT("[ERROR] 중복되지 않은 로또 번호를 입력해주세요."),
    BONUS_NUMBER_EMPTY("[ERROR] 보너스 번호를 입력해주세요."),
    BONUS_NUMBER_TYPE("[ERROR] 정수를 입력해주세요."),
    BONUS_NUMBER_RANGE("[ERROR] 1에서 45사이의 정수를 입력해주세요."),
    BONUS_NUMBER_REPEAT("[ERROR] 당첨 번호와 중복되지 않은 수를 입력해주세요.")
}

class Validator {
    fun validatePurchaseAmount(purchaseAmount: String): String {
        if (purchaseAmount.isEmpty()) {
            throw IllegalArgumentException(InputErrorMessage.PURCHASE_AMOUNT_EMPTY.errorMessage)
        }
        return purchaseAmount
    }

    fun validatePurchaseInt(purchaseAmount: String): Int {
        return purchaseAmount.toIntOrNull()
            ?: throw IllegalArgumentException(InputErrorMessage.PURCHASE_AMOUNT_TYPE.errorMessage)
    }

    fun validatePurchaseRange(purchaseAmount: Int): Int {
        if (purchaseAmount < PURCHASE_AMOUNT_UNIT) {
            throw IllegalArgumentException(InputErrorMessage.PURCHASE_AMOUNT_VALUE.errorMessage)
        }
        return purchaseAmount
    }

    fun validatePriceUnit(purchaseAmount: Int): Int {
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw IllegalArgumentException(InputErrorMessage.PURCHASE_AMOUNT_UNIT.errorMessage)
        }
        return purchaseAmount
    }

    fun validateLottoNumberInput(lottoNumber: String): String {
        if (lottoNumber.isEmpty()) {
            throw IllegalArgumentException(InputErrorMessage.LOTTO_NUMBER_EMPTY.errorMessage)
        }
        return lottoNumber
    }

    fun validateLottoNumber(lottoNumbers: String): List<String> {
        val numberList = lottoNumbers.split(',').map { it.trim() }
        for (element in numberList) {
            if (element.toIntOrNull() == null) {
                throw IllegalArgumentException(InputErrorMessage.LOTTO_NUMBER_TYPE.errorMessage)
            }
        }
        return numberList
    }

    fun validateLottoSize(lottoNumbers: List<String>) {
        if (lottoNumbers.size != Constant.LOTTO_NUMBER_SIZE) {
            throw IllegalArgumentException(InputErrorMessage.LOTTO_NUMBER_SIZE.errorMessage)
        }
    }

    fun validateLottoRange(lottoNumbers: List<String>): List<Int> {
        val intLottoNumbers = mutableListOf<Int>()
        for (element in lottoNumbers) {
            val currentNumber = element.toInt()
            if (currentNumber !in Constant.LOTTO_NUMBER_START..Constant.LOTTO_NUMBER_END) {
                throw IllegalArgumentException(InputErrorMessage.LOTTO_NUMBER_RANGE.errorMessage)
            }
            intLottoNumbers.add(currentNumber)
        }
        return intLottoNumbers
    }

    fun validateLottoRepeat(lottoNumbers: List<Int>) {
        val set = HashSet<Int>()
        for (element in lottoNumbers) {
            if (!set.add(element)) {
                throw IllegalArgumentException(InputErrorMessage.LOTTO_NUMBER_REPEAT.errorMessage)
            }
        }
    }

    fun validateBonusNumberInput(bonusNumber: String): String {
        if (bonusNumber.isEmpty()) {
            throw IllegalArgumentException(InputErrorMessage.BONUS_NUMBER_EMPTY.errorMessage)
        }
        println()
        return bonusNumber
    }

    fun validateBonusNumber(inputNumber: String): Int {
        return inputNumber.toIntOrNull()
            ?: throw IllegalArgumentException(InputErrorMessage.BONUS_NUMBER_TYPE.errorMessage)
    }

    fun validateBonusNumberRange(inputNumber: Int) {
        if (inputNumber !in Constant.LOTTO_NUMBER_START..Constant.LOTTO_NUMBER_END) {
            throw IllegalArgumentException(InputErrorMessage.BONUS_NUMBER_RANGE.errorMessage)
        }
    }

    fun validateBonusRepeat(inputNumber: Int, lottoNumbers: List<Int>) {
        if (inputNumber in lottoNumbers) {
            throw IllegalArgumentException(InputErrorMessage.BONUS_NUMBER_REPEAT.errorMessage)
        }
    }

    companion object {
        const val PURCHASE_AMOUNT_UNIT = 1000
    }
}