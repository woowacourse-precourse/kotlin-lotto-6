package lottonumbercomparator

import org.junit.jupiter.api.BeforeEach

class LottoNumberComparatorTest {
    private lateinit var lottoNumberComparator: LottoNumberComparator

    @BeforeEach
    fun setUp() {
        lottoNumberComparator = LottoNumberComparatorImpl()
    }
}