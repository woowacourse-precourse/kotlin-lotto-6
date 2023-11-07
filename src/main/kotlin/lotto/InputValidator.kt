package lotto

import camp.nextstep.edu.missionutils.Console

object InputValidator {
    fun validateBonusNumber(number: Int) {
        require(number in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

    fun validatePurchaseAmount(userInput: String) {
        require(userInput.all { it.isDigit() }) { "[ERROR] 로또 구입 금액은 0보다 큰 숫자여야 합니다?" }
        val amount = userInput.toInt()
        require(amount % 1000 == 0) { "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다." }
    }

    fun validateWinningNumber(userInput: String) {
        require(userInput.all{ it.isDigit() ||  it == ',' || it == ' '})
        val numbers = userInput.split(",").map{ it.toInt() }
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
        require(numbers.toSet().size == 6) // Set 자료구조로 변환해 중복 여부 확인
    }
}
