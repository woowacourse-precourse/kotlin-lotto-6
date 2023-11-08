package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StatsKtTest {

    @Test
    @DisplayName("일치하는 번호 개수에 맞는 Stats 반환 확인")
    fun checkStat() {
        val stats = mapOf(
            0 to false,
            3 to false,
            4 to false,
            5 to false,
            6 to false
        )

        val result = listOf(Stats.NONE, Stats.FIFTH, Stats.FOURTH, Stats.THIRD, Stats.FIRST)
        var index = 0
        for (stat in stats) {
            assertThat(checkStat(stat.key, stat.value))
                .isEqualTo(result[index++])
        }

        assertThat(checkStat(5, true)).isEqualTo(Stats.SECOND)
    }
}