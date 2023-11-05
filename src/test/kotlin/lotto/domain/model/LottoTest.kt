package lotto.domain.model

import lotto.Lotto
import lotto.domain.service.LottoCalculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoTest {
    lateinit var lotto: Lotto

    @BeforeEach
    fun `setUp`() {
        lotto = Lotto(listOf(1,2,3,4,5,6))
    }

    @Test
    fun `로또 번호가 6개가 아닌 경우 예외가 발생 한다`() {
        Lotto(listOf(1,2,3,4,5))
    }

}