package ui

const val MSG_ERR_ONLY_DIGIT = "[ERROR] 숫자를 입력해주세요."
const val MSG_ERR_INVALIDATE_INPUT = "[ERROR] 유효하지 않은 입력입니다."
const val MSG_ERR_PURCHASE_RANGE = "[ERROR] 구매 가능 금액은 1000원 ~ 10만원 입니다."
const val MSG_ERR_DIVISIBLE_BY_THOUSAND = "[ERROR] 구매 금액은 1000원 단위로 입력해주세요."
const val MSG_ERR_SIX_DISTINCT_NUMBER = "[ERROR] 로또 번호는 서로 다른 6자리 수만 가능합니다."
const val MSG_ERR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
const val MSG_ERR_BONUS_NOT_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."

const val MIN_PURCHASE_MONEY = 1000
const val MAX_PURCHASE_MONEY = 100_000
const val MIN_LOTTO_RANGE = 1
const val MAX_LOTTO_RANGE = 45
const val PROPER_LOTTO_SIZE = 6

object InputValidator {

    fun checkIsDigit(input: String): InputValidator {
        require(input.all { it.isDigit() }) { MSG_ERR_ONLY_DIGIT }

        return this
    }

    fun checkIsEmptyString(input: String): InputValidator {
        require(input.isNotEmpty()) { MSG_ERR_INVALIDATE_INPUT }

        return this
    }

    fun checkPurchaseRange(money: Int): InputValidator {
        require(money in MIN_PURCHASE_MONEY..MAX_PURCHASE_MONEY) { MSG_ERR_PURCHASE_RANGE }

        return this
    }

    fun checkIsDivisibleByThousand(money: Int): InputValidator {
        require(
            money >= 1000 &&
                    money % 1000 == 0
        ) { MSG_ERR_DIVISIBLE_BY_THOUSAND }

        return this
    }

    fun checkProperNumbersSize(numbers: List<Int>): InputValidator {
        require(
            numbers.distinct()
                .size == PROPER_LOTTO_SIZE
        ) { MSG_ERR_SIX_DISTINCT_NUMBER }

        return this
    }

    fun checkNumberListInRange(numbers: List<Int>): InputValidator {
        for (number in numbers) checkNumberInRange(number)

        return this
    }

    fun checkNumberInRange(number: Int): InputValidator {
        require(number in MIN_LOTTO_RANGE..MAX_LOTTO_RANGE) { MSG_ERR_LOTTO_NUMBER_RANGE }

        return this
    }

    fun checkIsExistingNumber(number: Int, duplicateNumbers: List<Int>): InputValidator {
        require(!(duplicateNumbers.contains(number))) { MSG_ERR_BONUS_NOT_DUPLICATE }

        return this
    }
}