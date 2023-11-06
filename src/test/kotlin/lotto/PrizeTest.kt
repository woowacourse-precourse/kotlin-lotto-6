package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class PrizeTest {
    @Test
    fun `등수 총 개수 확인 테스트`() {
        var prize = mutableListOf<Prize>(Prize.MISS, Prize.FOURTH, Prize.FIRST, Prize.FIRST, Prize.FIFTH, Prize.FIFTH)
        var prizeList = getPrizeList(prize)
        assertThat(prizeList).containsExactly(2,0,0,1,2,1)
    }
}