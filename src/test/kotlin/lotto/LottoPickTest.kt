package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoPickTest {

    @Test
    fun `당첨 번호 입력이 6개 미만이면 에러 발생`(){
        val pickNumber:List<String> = listOf("1","2","3","4","5")
        assertThrows<IllegalArgumentException> {
            LottoPick().pickValid(pickNumber)
        }
    }

    @Test
    fun `당첨 번호 입력에서 숫자가 아닌 정보가 들어오면 에러 발생`(){
        val pickNumber:List<String> = listOf("1","2","3","4","5","ss")
        assertThrows<IllegalArgumentException> {
            LottoPick().pickValid(pickNumber)
        }
    }

    @Test
    fun `보너스 번호 입력 시 숫자가 아니면 에러 발생`(){
        assertThrows<IllegalArgumentException> {
            LottoPick().bonusCheck("ss")
        }
    }
    @Test
    fun `보너스 번호 입력 시 숫자 범위가 아니면 에러 발생`(){
        assertThrows<IllegalArgumentException> {
            LottoPick().bonusCheck("50")
        }
    }
    @Test
    fun `보너스 번호 입력 시 당첨 번호에 있다면 에러 발생`(){
        val pickNumber:List<Int> = listOf(1,2,3,4,5)
        assertThrows<IllegalArgumentException> {
            LottoPick().bonusRepeat(2,pickNumber)
        }
    }
}