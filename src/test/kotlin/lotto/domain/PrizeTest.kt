package lotto.domain

import org.assertj.core.api.Assertions.assertThat
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
    fun `상금을 출력할 때에는 화폐 단위로 출력된다`(){
        //given
        val prize = Prize(2_000_000_000)

        //when

        //then
        val actual = prize.toString()
        val expected = "2,000,000,000원"
        assertThat(actual).isEqualTo(expected)
    }
}