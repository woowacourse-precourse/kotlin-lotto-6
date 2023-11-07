package lotto

object InputValidator {
    fun validateBonusNumber(number: Int) {
        require(number in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

    fun validatePurchaseAmount(amount: Int) {
        require(amount % 1000 == 0) { "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다." }
    }
}
