package lotto

class Validation {
    fun purchaseMoneyValidation(purchaseMoney: String) {
        return checkValidPurchaseMoney(purchaseMoney)
    }

    fun lottoNumberValidation(lottoNumber: String) {
        return checkValidLottoNumber(lottoNumber)
    }

    private fun checkValidPurchaseMoney(purchaseMoney: String) {
        val purchaseMoneyToInt = purchaseMoney.toIntOrNull()
        require(purchaseMoneyToInt != null) { "구입 금액은 숫자만 입력 받을 수 있습니다." }
        require(purchaseMoneyToInt % 1000 == 0) { "구입 금액은 1000의 배수여야 합니다." }
    }

    private fun checkValidLottoNumber(lottoNumber: String) {
        val lottoNumberToInt = lottoNumber.toIntOrNull()
        require(lottoNumberToInt != null) { "로또 숫자는 1 ~ 45 사이의 숫자이어야 합니다." }
        require(lottoNumberToInt in 1..45) { "로또 숫자는 1 ~ 45 사이의 숫자이어야 합니다." }
    }
}