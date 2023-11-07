package lottonumbergenerator

import org.junit.jupiter.api.BeforeEach

class LottoNumberGeneratorTest {

    private lateinit var lottoNumberGenerator: LottoNumberGenerator

    @BeforeEach
    fun setUp() {
        lottoNumberGenerator = LottoNumberGeneratorImpl()
    }
}