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
            } && numbers.distinct().size == numbers.size && bonus in 1..GameConst.MAX_NUM && numbers.contains(bonus).not()
        ){
            StringRes.NUMBER_RANGE_ERR
        }
    }
}       