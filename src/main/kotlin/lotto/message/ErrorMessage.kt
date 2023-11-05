package lotto.message

object ErrorMessage {

    const val CHARACTER_IN_NUMBER = "[ERROR] 금액에 문자 감지\n"
    const val CAN_NOT_DIVIDE_NUMBER = "[ERROR] 금액을 나눌 수 없음\n"

    const val ANSWER_DUPLICATED_NUMBER = "[ERROR] 정답 숫자에 중복된 값 입력\n"
    const val ANSWER_NUMBER_VALUE_EXCEED = "[ERROR] 정답 숫자의 범위 초과\n"
    const val ANSWER_NUMBER_AMOUNT_EXCEED = "[ERROR] 정답 입력 갯수 초과\n"
    const val ANSWER_NOT_A_NUMBER = "[ERROR] 정답 입력에서 감지\n"

    const val BONUS_NUMBER_VALUE_OVER = "[ERROR] 보너스 숫자의 범위 초과\n"
    const val BONUS_NUMBER_AMOUNT_OVER = "[ERROR] 보너스 숫자 입력 갯수 초과\n"
    const val BONUS_NUMBER_NOT_A_NUMBER = "[ERROR] 보너스 숫자 문자 감지\n"

}