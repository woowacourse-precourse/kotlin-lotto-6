package lotto

import lotto.model.Lotto
import lotto.model.Store
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StoreTest {
    private lateinit var store: Store

    @BeforeEach
    fun setUp() {
        store = Store()
    }

    @Test
    fun `넘겨받은 로또 갯수만큼 로또를 발행한다`() {
        val piece = 10
        val lottoCollection = store.produceLottoNumber(piece)

        assertTrue(lottoCollection.size == piece)
    }
}