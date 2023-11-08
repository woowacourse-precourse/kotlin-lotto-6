package lotto.lotto.winning

import lotto.consts.GameConst
import lotto.consts.ErrorStringRes

data class WinningNumber(
    val numbers: List<Int>,
    val bonus: Int
) {
    init {
        require(
            numbers.all {
                it in 1..GameConst.MAX_NUM
            }){
            ErrorStringRes.NUMBER_RANGE_ERR
        }
        require(numbers.distinct().size == numbers.size) {
            ErrorStringRes.WINNING_LIST_DISTINCT
        }
        require(bonus in 1..GameConst.MAX_NUM) {
            ErrorStringRes.NUMBER_RANGE_ERR
        }
        require(numbers.contains(bonus).not()) {
            ErrorStringRes.WINNING_LIST_DISTINCT
        }
    }
}       