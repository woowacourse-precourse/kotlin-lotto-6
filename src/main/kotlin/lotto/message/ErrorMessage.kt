package lotto.message

object ErrorMessage {

    const val CHARACTER_IN_NUMBER = "[ERROR] 금액에서 문자 감지\n"
    const val CAN_NOT_DIVIDE_NUMBER = "[ERROR] 금액을 나눌 수 없음\n"

    const val ANSWER_DUPLICATED_NUMBER = "[ERROR] 당첨 숫자 내부 중복된 값 입력\n"
    const val ANSWER_NUMBER_VALUE_EXCEED = "[ERROR] 당첨 숫자 숫자 범위(1~45) 초과\n"
    const val ANSWER_NUMBER_AMOUNT_EXCEED = "[ERROR] 당첨 숫자 최대 입력 갯수 초과 (6글자)\n"
    const val ANSWER_NUMBER_AMOUNT_LITTLE = "[ERROR] 당첨 숫자 최대 입력 갯수 미만 (6글자)\n"
    const val ANSWER_NOT_A_NUMBER = "[ERROR] 당첨 숫자 입력에서 문자 감지\n"

    const val BONUS_NUMBER_VALUE_OVER = "[ERROR] 보너스 숫자 범위 초과\n"
    const val BONUS_NUMBER_AMOUNT_OVER = "[ERROR] 보너스 숫자 최대 입력 갯수 초과\n"
    const val BONUS_NUMBER_NOT_A_NUMBER = "[ERROR] 보너스 숫자 입력에서 문자 감지\n"

}