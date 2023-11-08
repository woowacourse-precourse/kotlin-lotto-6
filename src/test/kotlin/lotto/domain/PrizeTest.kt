package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PrizeTest{
    @Test
    fun `상금은 음수일 수 없다`(){
        //given

        //when

        //then
        assertThrows<IllegalArgumentException>{
            val prize = Prize(-1)
        }
    }

    @Test
    fun `상금을 출력하면 세 자리마다 `(){
        //given

        //when

        //then
        assertThrows<IllegalArgumentException>{
            val prize = Prize(-1)
        }
    }
}