package lotto

import camp.nextstep.edu.missionutils.Console

object InputValidator {
    fun validateBonusNumber(userInput: String, winningNumbers: List<Int>) {
        require(userInput.all{ it.isDigit() }) { "보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
        require(userInput.toInt() in 1..45) { "보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
        if (winningNumbers.contains(userInput.toInt()))
            throw IllegalStateException("보너스 번호는 당첨 번호의 숫자들과 별개의 숫자여야 합니다.")
        // IllegalStateException에러를 전달하기 위한 if 구문
    }

    fun validatePurchaseAmount(userInput: String) {
        require(userInput.all { it.isDigit() }) { "로또 구입 금액은 1,000원 단위의 숫자여야 합니다." }
        val amount = userInput.toInt()
        require(amount % 1000 == 0) { "로또 구입 금액은 1,000원 단위여야 합니다." }
    }

    fun validateWinningNumber(userInput: String) {
        require(userInput.all{ it.isDigit() ||  it == ',' || it == ' '})
        val numbers = userInput.split(",").map{ it.trim().toInt() }
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
        require(numbers.toSet().size == 6) // Set 자료구조로 변환해 중복 여부 확인
    }
}
