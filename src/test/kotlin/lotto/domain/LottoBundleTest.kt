package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoBundleTest{
    @Test
    fun `로또 등수를 계산하기 전 수익률을 계산할 수 없다`(){
        //given
        val lottoBundle = LottoBundle(listOf(Lotto(listOf(1,2,3,4,5,6))))

        //when

        //then
        assertThrows<IllegalStateException>{
            lottoBundle.getRateOfReturn()
        }
    }
}