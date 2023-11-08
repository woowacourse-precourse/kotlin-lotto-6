package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoGenerateTest {
    private val generateLotto = LottoGenerate()

    @Test
    fun `생성된 로또의 형식이 올바른지 테스트`() {
        assertDoesNotThrow {
            val lotto = generateLotto.issueLotto()
        }
    }
}