package lotto.model

import lotto.model.LottoWinningNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoWinningNumbersTest {
    @Test
    fun `로또 당첨 번호에만 중복된 숫자가 있는 경우`(){
        assertThrows<IllegalArgumentException> { LottoWinningNumbers(listOf(1,1,2,3,4,5),1) }
    }

    @Test
    fun `로또 당첨 번호는 중복되지 않았으나 보너스 번호가 기존 번호와 중복된 경우`(){
        assertThrows<IllegalArgumentException> { LottoWinningNumbers(listOf(1,2,3,4,5,6),1) }
    }

    @Test
    fun `로또 당첨 번호, 보너스 번호 둘 다 중복이 발생한 경우`(){
        assertThrows<IllegalArgumentException> { LottoWinningNumbers(listOf(1,1,3,4,5,6),6) }
    }
}