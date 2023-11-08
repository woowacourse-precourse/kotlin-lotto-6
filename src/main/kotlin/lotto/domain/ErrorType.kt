package lotto.domain

enum class ErrorType(val message: String) {
    IS_NOT_INTEGER("입력 값이 숫자가 아닙니다."),
    IS_NOT_POSITIVE_INTEGER("입력 값이 정수가 아닙니다."),
    IS_CONTAIN_DUPLICATES("중복 된 로또 번호가 있습니다."),
    IS_INCORRECT_NUMBER(
        "${LottoRule.START_INCLUSIVE.num}~" +
                "${LottoRule.END_INCLUSIVE.num} 범위의 로또 번호가 아닙니다."
    ),
    IS_INCORRECT_PURCHASE("올바르지 않은 구매 금액입니다.(${LottoRule.PRICE.num}원 단위 입력)"),
    IS_NOT_ENOUGH_COST("${LottoRule.PRICE.num}원 이상을 지불해야 합니다."),
    IS_BLANK("빈 값이 입력 되었습니다."),
    IS_NOT_SIX_NUMBERS("로또 번호가 ${LottoRule.COUNT.num}개가 아닙니다."),
}