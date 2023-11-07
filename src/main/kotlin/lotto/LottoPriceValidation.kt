package lotto


fun validateLottoPrice(price: Int) {
    require(isValidInteger(price.toString())) { "[ERROR] 주어진 금액이 음이 아닌 정수가 아닙니다." }
    require(isPriceMultipleOf1000(price)) { "[ERROR] 주어진 금액이 1000의 배수가 아닙니다." }
}