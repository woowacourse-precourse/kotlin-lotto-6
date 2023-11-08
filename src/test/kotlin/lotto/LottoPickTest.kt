package lotto

import lotto.model.LottoBonus
import lotto.user.LottoPick
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
    fun `당첨 번호 입력 시 1~45 범위에 있는 숫자가 아니면 에러 발생`(){
        val pickNumber:List<String> = listOf("1","2","3","4","5","55")
        assertThrows<IllegalArgumentException> {
            LottoPick().pickValid(pickNumber)
        }
    }

    @Test
    fun `당첨 번호 입력 시 빈칸까지 6개 초과이지만 유효한 숫자 6개인 경우에도 에러 발생`(){
        val pickNumber:List<String> = listOf("1","2","3","4","5","6","",)
        assertThrows<IllegalArgumentException> {
            LottoPick().pickValid(pickNumber)
        }
    }

}