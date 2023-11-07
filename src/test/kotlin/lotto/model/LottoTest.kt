package lotto.model

import lotto.model.Lotto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoTest {
    private val lotto = Lotto(listOf(1,2,3,4,5,6))

    @Test
    @DisplayName("로또에 당첨되었는지 확인하고 로또 결과를 반환한다.")
    fun checkLottoWinningTest(){
        val bonusNum = 7
        val lottoLists = listOf(listOf(8,21,23,41,42,43), listOf(1,2,3,5,6,7), listOf(1,3,4,5,9,21))
        val expected = listOf(0,100,4)
        val actualValue = lotto.checkLottoWinning(bonusNum,lottoLists)
        assertEquals(expected,actualValue)
    }
}
