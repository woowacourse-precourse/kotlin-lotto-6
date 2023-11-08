package lotto.input

import lotto.consts.GameConst
import lotto.consts.StringRes

enum class InputValidateEnum(val validator: (String) -> (Unit)) {
    BUDGET({ input ->
        require(input.isBlank().not()) {
            StringRes.INPUT_EMPTY_LINE_ERR
        }
        require(input.toList().all {
            it.code in 48..58
        }) {
            StringRes.INPUT_CHAR_ERR
        }
        require(input.toInt() % GameConst.COST == 0) {
            StringRes.BUDGET_REMAIN_ERR
        }
    }),

    WINNING_NUMBER({ input ->
        require(input.isBlank().not()) {
            StringRes.INPUT_EMPTY_LINE_ERR
        }
        val numbers = input.split(",").map { it.trim() }.map { it.toIntOrNull() ?: IllegalArgumentException(StringRes.INPUT_CHAR_ERR) }
        require(numbers.distinct().size == numbers.size){
            StringRes.WINNING_LIST_DISTINCT
        }
        require(numbers.all {
            it in 1..GameConst.MAX_NUM
        }){
            StringRes.INPUT_OUT_OF_RANGE
        }
        require(numbers.size == GameConst.NUM_COUNT){
            StringRes.WINNING_LIST_COUNT_ERR
        }
    }),
    
    BONUS({ input ->
        require(input.isBlank().not()) {
            StringRes.INPUT_EMPTY_LINE_ERR
        }
        require(input.toList().all {
            it.code in 48..58
        }) {
            StringRes.INPUT_CHAR_ERR
        }
        require(input.toInt() in 1..GameConst.MAX_NUM) {
            StringRes.INPUT_OUT_OF_RANGE
        }
    })


}