package util

import util.Constants.MAX_LOTTO_RANGE
import util.Constants.MAX_PURCHASE_MONEY
import util.Constants.MIN_LOTTO_RANGE
import util.Constants.MIN_PURCHASE_MONEY
import util.Constants.PROPER_LOTTO_SIZE

object Validator {

    fun checkIsDigit(input: String): Validator {
        require(input.all{ it.isDigit() }) {"[ERROR] 숫자를 입력해주세요. 숫자가 여러 개인 경우 쉼표(,)로 구분해주세요. 예) 1,2,3,4,5,6"}

        return this
    }

    fun checkIsEmptyString(input: String): Validator {
        require(input.isNotEmpty()) {"[ERROR] 유효하지 않은 입력입니다."}

        return this
    }

    fun checkPurchaseRange(money: Int): Validator {
        require(money in MIN_PURCHASE_MONEY..MAX_PURCHASE_MONEY) {"[ERROR] 구매 가능 금액은 1000원 ~ 10만원 입니다."}

        return this
    }

    fun checkIsDivisibleByThousand(money: Int): Validator {
        require(
            money >= 1000 &&
            money % 1000 == 0
        ) {"[ERROR] 구매 금액은 1000원 단위로 입력해주세요."}

        return this
    }

    fun checkProperNumbersSize(numbers: List<Int>): Validator {
        require(
            numbers.distinct()
                .size == PROPER_LOTTO_SIZE
        ) {"[ERROR] 로또 번호는 서로 다른 6자리 수만 가능합니다. 숫자가 여러 개인 경우 쉼표(,)로 구분해주세요. 예) 1,2,3,4,5,6"}

        return this
    }

    fun checkNumberListInRange(numbers: List<Int>): Validator {
        for(number in numbers) checkNumberInRange(number)

        return this
    }

    fun checkNumberInRange(number: Int): Validator {
        require(number in MIN_LOTTO_RANGE..MAX_LOTTO_RANGE) {"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."}

        return this
    }

}