package lotto

import lotto.model.LottoRank
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoGameServiceTest {

    private val lottoGameService = LottoGameService()

    @Test
    fun `calculateLottoPurchaseQuantity 메서드 테스트`() {
        val purchaseAmount = 10000
        val ticket = lottoGameService.calculateLottoPurchaseQuantity(purchaseAmount)
        assertEquals(10, ticket)
    }

    @Test
    fun `lottoNumberGenerator 메서드 테스트`() {
        val ticket = 5
        val result = lottoGameService.lottoNumberGenerator(ticket)
        assertEquals(ticket, result.size)
        result.values.forEach { lottoNumbers ->
            assertEquals(6, lottoNumbers.size)
        }
    }

    @Test
    fun `checkWinningLottoNumber 메서드 테스트`() {
        val lotto = listOf(1, 2, 3, 4, 5, 6)
        val randomLottoLists = mutableMapOf(0 to listOf(1, 2, 3, 4, 5, 6))
        val count = randomLottoLists[0]!!.intersect(lotto.toSet()).count()
        assertEquals(6, count)
    }

    @Test
    fun `checkWinningBonusNumber 메서드 테스트`() {
        val bonus = "7"
        val randomLottoLists = mutableMapOf(0 to listOf(1, 2, 3, 4, 5, 6, 7))
        val hasBonus = randomLottoLists[0]!!.contains(bonus.toInt())
        assertEquals(true, hasBonus)
    }

    @Test
    fun `calculateProfitPercentage 메서드 테스트`() {
        val purchaseAmount = 10000
        LottoRank.THREE_MATCH.increment()
        LottoRank.FOUR_MATCH.increment()
        val profitPercentage = lottoGameService.calculateProfitPercentage(purchaseAmount.toDouble())
        assertEquals(550.0, profitPercentage)
    }

    @Test
    fun `convertStringToList 메서드 테스트`() {
        val enterWinningNumbers = "1, 2, 3, 4, 5, 6"
        val numbers = lottoGameService.convertStringToList(enterWinningNumbers)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), numbers)
    }
}