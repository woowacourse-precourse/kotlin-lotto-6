package lotto.util

import lotto.constant.LottoConstant

object ValidationUtil {

    fun validatePurchaseAmount(userInputPurchaseAmount: String) {
        val purchaseAmount =
            userInputPurchaseAmount.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 유효하지 않은 금액입니다.")
        require(purchaseAmount > 0) { "[ERROR] 구매 금액은 양수여야 합니다." }
        require(purchaseAmount % LottoConstant.LOTTO_PRICE == 0) { "[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다." }
    }

    fun validateWinningNumbers(userInputWinningNumbers: String) {
        val numbers = userInputWinningNumbers.split(",")
        require(numbers.size == LottoConstant.LOTTO_SIZE) { "[ERROR] 당첨 번호는 6개여야 합니다." }
        val parsedNumbers = numbers.map { numberString ->
            numberString.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 유효하지 않은 당첨 번호입니다.")
        }
        require(parsedNumbers.distinct().size == LottoConstant.LOTTO_SIZE) { "[ERROR] 당첨 번호는 중복될 수 없습니다." }
        require(parsedNumbers.all { it in LottoConstant.LOTTO_MIN..LottoConstant.LOTTO_MAX }) { "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

    fun validateBonusNumber(userInputBonusNumber: String, winningNumbers: List<Int>) {
        val bonusNumber = userInputBonusNumber.toIntOrNull()
        requireNotNull(bonusNumber) { "[ERROR] 유효하지 않은 보너스 번호입니다." }
        require(bonusNumber in LottoConstant.LOTTO_MIN..LottoConstant.LOTTO_MAX) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(bonusNumber !in winningNumbers) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

}