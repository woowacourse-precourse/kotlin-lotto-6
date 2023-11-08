package lotto.consts

object StringRes {
    private const val ERR_PREFIX = "[ERROR] "
    const val NUMBER_RANGE_ERR = "${ERR_PREFIX}번호가 잘못되었습니다."
    const val BASE_CREATE_LOTTO_OUT_OF_RANGE = "${ERR_PREFIX}주어진 리스트보다 많은 로또를 생성하였습니다."
    const val BUDGET_REMAIN_ERR = "${ERR_PREFIX}예산이 남습니다."
    const val INPUT_CHAR_ERR ="${ERR_PREFIX}숫자만 들어갈 수 있습니다."
    const val INPUT_EMPTY_LINE_ERR ="${ERR_PREFIX}입력이 비어있습니다."
    const val WINNING_LIST_DISTINCT ="${ERR_PREFIX}숫자가 중복 되었습니다."
    const val INPUT_OUT_OF_RANGE ="${ERR_PREFIX}범위를 벗어난 숫자입니다."
    const val WINNING_LIST_COUNT_ERR ="${ERR_PREFIX}숫자의 개수가 올바르지 않습니다."
}