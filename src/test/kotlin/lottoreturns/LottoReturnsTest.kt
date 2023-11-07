package lottoreturns

import org.junit.jupiter.api.BeforeEach

class LottoReturnsTest {
    private lateinit var lottoReturns: LottoReturns

    @BeforeEach
    fun setUp() {
        lottoReturns = LottoReturnsImpl()
    }
}