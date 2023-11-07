package lotto

data class WinningNumber(
    val numbers: List<Int>,
    val bonus: Int
) {
    init {
        check(
            numbers.all {
                it in 1..GameConst.MAX_NUM
            } && numbers.distinct().size == numbers.size && bonus in 1..GameConst.MAX_NUM
        ){
            StringRes.NUMBER_RANGE_ERR
        }
    }
}