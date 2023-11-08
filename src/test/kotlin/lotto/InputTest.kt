package lotto

import lotto.consts.ErrorStringRes
import lotto.input.Input
import lotto.input.InputValidateEnum
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest {
    @Test
    fun `1000원 단위가 아님`(){
        assertThrows<IllegalArgumentException>(ErrorStringRes.BUDGET_REMAIN_ERR) {
            InputValidateEnum.BUDGET.validator("1200")
        }
    }

    @Test
    fun `숫자가 아닌 것 포함`(){
        assertThrows<IllegalArgumentException>(ErrorStringRes.INPUT_CHAR_ERR) {
            InputValidateEnum.BUDGET.validator("1000j")
        }
    }

    @Test
    fun `빈라인`(){
        assertThrows<IllegalArgumentException>(ErrorStringRes.INPUT_EMPTY_LINE_ERR) {
            InputValidateEnum.BUDGET.validator("")
        }
    }

    @Test
    fun `빈번호`(){
        assertThrows<IllegalArgumentException>(ErrorStringRes.BUDGET_REMAIN_ERR) {
            InputValidateEnum.WINNING_NUMBER.validator("")
        }
    }

    @Test
    fun `중복된 번호`(){
        assertThrows<IllegalArgumentException>(ErrorStringRes.WINNING_LIST_DISTINCT) {
            InputValidateEnum.WINNING_NUMBER.validator("1,1,2,3,4,5")
        }
    }

    @Test
    fun `숫자가 아닌 번호`(){
        assertThrows<IllegalArgumentException>(ErrorStringRes.INPUT_CHAR_ERR) {
            InputValidateEnum.WINNING_NUMBER.validator("1,2,!,3,4,5")
        }
    }

    @Test
    fun `6개 보다 많거나 적은 번호`(){
        assertThrows<IllegalArgumentException>(ErrorStringRes.BUDGET_REMAIN_ERR) {
            InputValidateEnum.WINNING_NUMBER.validator("1,2")
        }
    }

    @Test
    fun `범위를 벗어난 번호`(){
        assertThrows<IllegalArgumentException>(ErrorStringRes.BUDGET_REMAIN_ERR) {
            InputValidateEnum.WINNING_NUMBER.validator("1,2,3,4,5,46")
        }
    }

    @Test
    fun `숫자가 아닌 보너스 번호`(){
        assertThrows<IllegalArgumentException>(ErrorStringRes.INPUT_CHAR_ERR) {
            InputValidateEnum.BONUS.validator("!")
        }
    }

    @Test
    fun `범위를 벗어난 보너스 번호`(){
        assertThrows<IllegalArgumentException>(ErrorStringRes.INPUT_OUT_OF_RANGE) {
            InputValidateEnum.BONUS.validator("46")
        }
    }
}