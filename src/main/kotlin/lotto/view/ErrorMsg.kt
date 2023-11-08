package lotto.view

import kotlin.text.StringBuilder

enum class ErrorMsg(val eMsg: String) {
    ERROR("[ERROR] "),

    WRONG_PRICE("구입 금액은 1,000원 단위로 떨어져야 합니다."),
    STRING_PIRCE("구입 금액에 숫자를 입력해주세요"),

    WRONG_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복된 숫자가 없어야 합니다.");
}

fun concat(str1: ErrorMsg, str2: ErrorMsg): String {
    return StringBuilder(str1.eMsg).append(str1.eMsg).toString()
}