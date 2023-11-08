package lotto

import lotto.data.LottoNums
import lotto.domain.LottoOutputManager
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OutputManagerTest {

    private lateinit var outputManager: LottoOutputManager
    @BeforeEach
    fun setUp(){
        outputManager = LottoOutputManager()
    }

    @Test
    fun `결과값 잘 산출하는지 테스트`() {

        outputManager.calculateResult(listOf(listOf(1,2,3,4,5,6), listOf(1,2,3,8,9,19)), LottoNums(listOf(1,2,3,8,9,10),19))

        assertEquals(outputManager.getResult().three,1)
        assertEquals(outputManager.getResult().bonus,1)

    }

    @Test fun `수익률 테스트`() {
        outputManager.calculateResult(listOf(listOf(1,2,3,4,5,6), listOf(1,2,3,8,9,19)), LottoNums(listOf(1,2,3,8,9,10),19))

        outputManager.calculateRevenue(5000)
        val expected = 600100.0

        assertEquals(outputManager.getRevenue(),expected)
    }
}