package lotto

object ErrorMessage {
    const val ERROR = "[ERROR]"
    const val ERROR_INPUT_PURCHASE_PRICE = "$ERROR 1000단위로 입력해주세요."
    const val ERROR_INPUT_N0T_NUM = "$ERROR 숫자가 아닙니다."
    const val ERROR_LOW_PRICE = "$ERROR 1000원 밑으로는 구매할 수 없습니다."
    const val ERROR_NUMBER_OUT_OF_RANGE = "$ERROR 1~45 사이의 숫자만 입력해주세요"
    const val ERROR_INPUT_NUMBER_NO_FORMAT = "$ERROR 숫자가 아닌 값이 있습니다"
    const val ERROR_LIST_SIZE_OUT_OF_RANGE = "$ERROR 6개의 숫자를 입력해주세요"
    const val ERROR_NUMBER_DUPLICATED = "$ERROR 중복되는 숫자가 있습니다"
    const val ERROR_BONUS_DUPLICATED = "$ERROR 보너스 숫자는 당첨 번호와 중복될 수 없습니다."
}