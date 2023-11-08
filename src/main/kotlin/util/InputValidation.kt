package util

import java.text.DecimalFormat

enum class InputValidation(val message: String, val isValid: (String) -> Unit) {
    ONLY_NUMBER(
        "[ERROR] 숫자만 입력이 가능합니다.",
        fun(value: String) = require(value.all { it.isDigit() }) { ONLY_NUMBER.message },
    ),
    NUMBER_EMPTY(
        "[ERROR] 공백은 입력하실 수 없습니다.",
        fun(value: String) = require(value.isNotBlank()) { NUMBER_EMPTY.message },
    ),
    NUMBER_FORMAT(
        "[ERROR] 0으로 시작하는 숫자는 입력할 수 없습니다 .",
        fun(value: String) = require(value.first() != '0') { NUMBER_FORMAT.message },
    ),
    VALID_RANGE(
        "[ERROR] 최소 ${DecimalFormat("#,###").format(LottoConfiguration.MIN_PURCHASE_PRICE.value)}원 부터 " +
            "최대 ${DecimalFormat("#,###").format(LottoConfiguration.MAX_PURCHASE_PRICE.value)}원 까지 구매가 가능합니다.",
        fun(value: String) =
            require(value.toIntOrNull() in LottoConfiguration.MIN_PURCHASE_PRICE.value..LottoConfiguration.MAX_PURCHASE_PRICE.value) { VALID_RANGE.message },
    ),
    PURCHASE_IN_THOUSAND_WON(
        "[ERROR] ${DecimalFormat("#,###").format(LottoConfiguration.TICKET_PRICE.value)}원 단위로 구매가 가능합니다.",
        fun(value: String) =
            require(value.toInt() % LottoConfiguration.TICKET_PRICE.value == 0) { PURCHASE_IN_THOUSAND_WON.message },
    ),
    NUMBER_RANGE(
        "[ERROR] ${LottoConfiguration.MIN_NUMBER.value}부터 ${LottoConfiguration.MAX_NUMBER.value}까지만 입력이 가능합니다.",
        fun(value: String) =
            require(value.toIntOrNull() in LottoConfiguration.MIN_NUMBER.value..LottoConfiguration.MAX_NUMBER.value) { NUMBER_RANGE.message },
    ),
}
