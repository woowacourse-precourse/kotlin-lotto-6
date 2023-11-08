package lotto

fun isPriceMultipleOfTicketPrice(value: Int): Boolean {
    return value % LottoConstraints.TICKET_PRICE == 0
}


fun validateLottoPrice(price: Int) {
    require(price >= 0) { ErrorMessages.PRICE_IS_NEGATIVE }
    require(isPriceMultipleOfTicketPrice(price)) { ErrorMessages.PRICE_HAS_REMAINDER }
}
