package lotto

fun isValidInteger(digits: String): Boolean {
    return digits.all { it.isDigit() }
}

fun isPriceMultipleOfTicketPrice(value: Int): Boolean {
    return value % LottoConstraints.TICKET_PRICE == 0
}

