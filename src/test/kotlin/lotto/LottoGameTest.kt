package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream


class LottoGameTest {
    fun provideInput(input: String) {
        System.setIn(ByteArrayInputStream(input.toByteArray()))
    }

    @Test
    fun printBoughtLottos() {
        val lottoGamee = LottoGame()

        // 가짜 입력을 설정
        provideInput("1,2,3,4,5,6")

        val result2 = lottoGamee.readWinningNumber()

        // 테스트 단언문 작성
        assertEquals(listOf(1,2,3,4,5,6), result2)
    }

}