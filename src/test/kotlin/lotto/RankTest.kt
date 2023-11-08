package lotto

import lotto.model.Customer
import lotto.model.Lotto
import lotto.model.Rank
import lotto.model.Store
import lotto.model.Winning
import lotto.utils.Constants.FIFTH_PLACE
import lotto.utils.Constants.FIRST_PLACE
import lotto.utils.Constants.FOURTH_PLACE
import lotto.utils.Constants.SECOND_PLACE
import lotto.utils.Constants.THIRD_PLACE
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RankTest {
    private lateinit var customer: Customer
    private lateinit var winning: Winning
    private lateinit var rank: Rank

    @BeforeEach
    fun setUp() {
        customer = Customer(
            5000, mutableListOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 45)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 7, 8)),
                Lotto(listOf(1, 2, 3, 7, 8, 9)),
            )
        )
        winning = Winning(listOf(1, 2, 3, 4, 5, 6), 45)
        rank = Rank()
    }

    @Test
    fun `로또 숫자와 당첨 숫자를 비교해 등수를 분석한다`() {
        rank.analyzeLottoRanking(customer.getLottoCollection(), winning)

        Assertions.assertTrue(
            rank.getRank() == listOf(
                FIRST_PLACE,
                SECOND_PLACE,
                THIRD_PLACE,
                FOURTH_PLACE,
                FIFTH_PLACE
            )
        )
    }

    @Test
    fun `로또 당첨 개수가 정확한지 확인한다`() {
        rank.analyzeLottoRanking(customer.getLottoCollection(), winning)

        val rankingCountResult = rank.rankingCount(rank.getRank())
        println(rankingCountResult)

        Assertions.assertTrue(rankingCountResult == listOf(1, 1, 1, 1, 1))
    }
}