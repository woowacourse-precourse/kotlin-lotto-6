package lotto

object Message {

    const val ENTER_PURCHASE = "구입금액을 입력해 주세요."
    const val BOUGHT_N_PIECES = "개를 구매했습니다."
    const val ENTER_USER_PICK_NUMBERS = "당첨 번호를 입력해 주세요."
    const val ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    const val WINNING_STATISTICS = "당첨 통계"
    const val COMMA = "---"

    const val ERROR_USER_PICK_NUMBERS_DUPLICATION = "[ERROR] 중복된 번호를 입력하였습니다."
    const val ERROR_BONUS_NUMBER_DUPLICATION = "[ERROR] 앞서 입력된 당첨 번호와 중복된 번호를 입력하였습니다."
    const val ERROR_VALID_RANGE = "[ERROR] 당첨 번호 범위를 넘어선 번호를 입력하였습니다."
    const val ERROR_USER_PICK_NUMBERS_SIX_RANGE ="[ERROR] 6개 이상의 당첨 번호를 입력하였습니다."

    const val ERROR_RANDOM_NUMBER_DUPLICATION = "[ERROR] 중복된 로또번호가 생성 되었습니다."
    const val ERROR_RANDOM_NUMBER_RANGE = "[ERROR] 범위를 넘어선 로또번호가 생성 되었습니다."
    const val ERROR_RANDOM_NUMBER_SIX_RANGE = "[ERROR] 6개의 로또번호가 아니게 생성되었습니다."
    const val ERROR_RANDOM_NUMBER_SORTING = "[ERROR] 로또번호가 오름차순이 아닙니다."

    const val ERROR_USER_INPUT_NOT_INT = "[ERROR] 정수가 아닌 값이 입력되었습니다."
    const val ERROR_USER_INPUT_LESS_THAN_ZERO = "[ERROR] 0보다 작은 값이 입력되었습니다."
    const val ERROR_USER_INPUT_LESS_THAN_THOUSAND = "[ERROR] 로또는 1개당 1000원입니다. 1000원 이상의 값을 입력해주세요."

    const val ERROR_WIN_COUNT_CALCULATOR = "[ERROR] 당첨 계산이 잘못되었습니다."

}