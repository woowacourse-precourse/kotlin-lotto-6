package lotto


fun validateLottoPriceString(digits: String) {
    require(isValidInteger(digits)) {
        ErrorMessages.PRICE_NOT_INT
    }
}

fun validateLottoPrice(price: Int) {
    require(price >= 0) { ErrorMessages.PRICE_IS_NEGATIVE }
    require(isPriceMultipleOfTicketPrice(price)) { ErrorMessages.PRICE_HAS_REMAINDER }
}