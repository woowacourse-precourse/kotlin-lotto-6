package lotto

import lotto.model.LottoBonus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoBonusTest {

    @Test
    fun `보너스 번호 입력 시 숫자가 아니면 에러 발생`(){
        assertThrows<IllegalArgumentException> {
            LottoBonus().bonusCheck("ss")
        }
    }
    @Test
    fun `보너스 번호 입력 시 숫자 범위가 아니면 에러 발생`(){
        assertThrows<IllegalArgumentException> {
            LottoBonus().bonusCheck("50")
        }
    }
    @Test
    fun `보너스 번호 입력 시 당첨 번호에 있다면 에러 발생`(){
        val pickNumber:List<Int> = listOf(1,2,3,4,5)
        assertThrows<IllegalArgumentException> {
            LottoBonus().bonusRepeat(2,pickNumber)
        }
    }
}