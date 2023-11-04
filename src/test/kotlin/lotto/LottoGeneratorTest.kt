package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class LottoGeneratorTest {

    @Test
    fun `1 ~ 45 사이의 중복되지 않는 6자리 숫자를 생성해서 로또 객체에 담아 반환한다`() {
        assertDoesNotThrow{ LottoGenerator.create() }
    }
}