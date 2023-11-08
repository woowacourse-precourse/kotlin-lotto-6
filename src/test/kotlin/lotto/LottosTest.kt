package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottosTest {
    val lottosClass = Lottos()
    @Test
    fun `로또 5개를 구매 하였을때 정상적으로 로또가 생성되었는지 확인`() {
        val lottoNum = 5
        assertEquals(lottoNum, lottosClass.makeLotto(lottoNum).size)
    }
}