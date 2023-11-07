package lotto.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class PrizeTypeTest {

    @Test
    fun `getPrice 메서드로 각이름에 맞는 금액 및 대소문자 확인`() {
        // 각 상금의 이름에 해당하는 가격을 확인
        assertEquals(2000000000, PrizeType.getPrice("FIRST"))
        assertEquals(30000000, PrizeType.getPrice("SECOND"))
        assertEquals(1500000, PrizeType.getPrice("THIRD"))
        assertEquals(50000, PrizeType.getPrice("FOURTH"))
        assertEquals(5000, PrizeType.getPrice("FIFTH"))

        // 대문자 또는 소문자가 섞여 있어도 올바르게 동작하는지 확인
        assertEquals(2000000000, PrizeType.getPrice("fiRst"))
        assertEquals(30000000, PrizeType.getPrice("sEConD"))
        assertEquals(1500000, PrizeType.getPrice("tHiRd"))
        assertEquals(50000, PrizeType.getPrice("fOuRTh"))
        assertEquals(5000, PrizeType.getPrice("fiFTh"))

        // 상금 이름이 없을 때 기본값인 0을 반환하는지 확인
        assertEquals(0, PrizeType.getPrice("INVALID_PRIZE"))
    }

}
