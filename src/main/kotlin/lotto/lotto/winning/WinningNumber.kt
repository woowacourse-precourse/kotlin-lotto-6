package lotto.lotto.winning

import lotto.consts.GameConst
import lotto.consts.StringRes

data class WinningNumber(
    val numbers: List<Int>,
    val bonus: Int
) {
    init {
        require(
            numbers.all {
                it in 1..GameConst.MAX_NUM
            }){
            StringRes.NUMBER_RANGE_ERR
        }
        require(numbers.distinct().size == numbers.size) {
            StringRes.WINNING_LIST_DISTINCT
        }
        require(bonus in 1..GameConst.MAX_NUM) {
            StringRes.NUMBER_RANGE_ERR
        }
        require(numbers.contains(bonus).not()) {
            StringRes.WINNING_LIST_DISTINCT 
        }
    }
}       