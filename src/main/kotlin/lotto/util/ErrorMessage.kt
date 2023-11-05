package lotto.util

import lotto.util.Constants.LOTTO_SIZE

private const val ERROR_CONVENTION = "[ERROR] "

enum class ErrorMessage(val msg: String) {
    NOT_NOT_INTEGER(ERROR_CONVENTION +"입력 값은 정수여야 합니다."),
    NOT_POSITIVE_INTEGER(ERROR_CONVENTION + "입력 값은 0보다 큰 정수여야 합니다."),
    NOT_DIVISIBLE(ERROR_CONVENTION + "입력 값은 천 원 단위여야 합니다."),
    EMPTY_INPUT(ERROR_CONVENTION + "입력 값은 공백이 될 수 없습니다."),
    NOT_IN_RANGE(ERROR_CONVENTION + "입력 값은 1부터 45 사이의 정수로 구성되어야 합니다."),
    DUPLICATE_VALUES(ERROR_CONVENTION + "입력 값은 중복된 값이 존재하면 안됩니다."),
    INVALID_SIZE(ERROR_CONVENTION + "사이즈는 $LOTTO_SIZE 이어야 합니다."),
    ALREADY_EXISTS(ERROR_CONVENTION + "이미 존재하는 숫자입니다.")
}