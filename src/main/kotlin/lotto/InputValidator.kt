package lotto

import camp.nextstep.edu.missionutils.Console

object InputValidator {
    fun validateBonusNumber(userInput: String, winningNumbers: List<Int>) {
        val bonusNumber = userInput.toInt()

        require(bonusNumber in Constants.MIN_NUMBER..Constants.MAX_NUMBER) {
            "보너스 번호는 1부터 45 사이의 숫자여야 합니다."
        }
        require(!winningNumbers.contains(userInput.toInt())) { "보너스 번호는 당첨 번호의 숫자들과 별개의 숫자여야 합니다." }
    }

    fun validatePurchaseAmount(userInput: String) {
        val amount = userInput.toInt()

        require(amount % Constants.LOTTO_PRIZE == 0) { "로또 구입 금액은 1,000원 단위여야 합니다." }
    }

    fun validateWinningNumber(userInput: String) {
        val numbers = userInput.split(",").map{ it.trim().toInt() }

        require(numbers.size == Constants.LOTTO_SIZE) { "당첨 번호는 숫자 6개로 이루어져야 합니다." }
        require(numbers.all { it in Constants.MIN_NUMBER..Constants.MAX_NUMBER }) {
            "당첨 번호는 1부터 45사이의 숫자여야 합니다."
        }
        require(numbers.toSet().size == Constants.LOTTO_SIZE) { "당첨 번호에 중복되는 숫자가 없어야 합니다." }
        // Set 자료구조로 변환해 중복 여부 확인
    }
}
