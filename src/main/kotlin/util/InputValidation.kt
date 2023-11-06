package util

enum class InputValidation(val message: String, val isValid: (String) -> Unit) {
    ONLY_NUMBER(
        "[ERROR] 숫자만 입력이 가능합니다.",
        fun(value: String) = require(value.all { it.isDigit() }) { ONLY_NUMBER.message },
    ),
    PURCHASE_AMOUNT_EMPTY(
        "[ERROR] 구매 금액이 입력되지 않았습니다.",
        fun(value: String) = require(value.isNotBlank()) { PURCHASE_AMOUNT_EMPTY.message },
    ),
    NUMBER_EMPTY(
        "[ERROR] 구매 금액이 입력되지 않았습니다.",
        fun(value: String) = require(value.isNotBlank()) { PURCHASE_AMOUNT_EMPTY.message },
    ),
    NUMBER_FORMAT(
        "[ERROR] 올바른 숫자 형태가 아닙니다.",
        fun(value: String) = require(value.first() != '0') { NUMBER_FORMAT.message },
    ),
    VALID_RANGE(
        "[ERROR] 최소 1,000원 부터 최대 100,000원 까지 구매가 가능합니다.",
        fun(value: String) = require(value.toInt() in 1_000..100_000) { VALID_RANGE.message },
    ),
    PURCHASE_IN_THOUSAND_WON(
        "[ERROR] 1,000원 단위로 구매가 가능합니다.",
        fun(value: String) = require(value.toInt() % 1_000 == 0) { PURCHASE_IN_THOUSAND_WON.message },
    ),
}
