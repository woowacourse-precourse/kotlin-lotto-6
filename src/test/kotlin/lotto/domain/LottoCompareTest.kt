package lotto.domain

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class LottoCompareTest {
    @Test
    fun `당첨 로또 번호와 랜덤 번호를 비교 한다`() {
        val winning = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
        val lotto = mutableListOf<Lotto>(Lotto(listOf(1, 7, 8, 9, 10, 11)))
        val result = LottoCompare(lotto).compare(winning)
        assertTrue(result.size == 1)
    }

    @Test
    fun `보너스 로또 번호와 랜덤 번호 비교 한다`() {
        val bonus = 10
        val lotto = mutableListOf<Lotto>(Lotto(listOf(1, 7, 8, 9, 10, 11)))
        val result = LottoCompare(lotto).compareBonus(bonus)
        assertTrue(result == 1)
    }
}