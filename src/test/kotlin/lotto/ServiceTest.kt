package lotto

import lotto.model.BallMachine
import lotto.model.Lotto
import lotto.model.User
import lotto.model.User.Companion.FIVE_AND_BONUS_MATCH
import lotto.model.User.Companion.FIVE_AND_BONUS_MATCH_REWARD
import lotto.model.User.Companion.FIVE_MATCH
import lotto.model.User.Companion.FIVE_MATCH_REWARD
import lotto.model.User.Companion.FOUR_MATCH
import lotto.model.User.Companion.FOUR_MATCH_REWARD
import lotto.model.User.Companion.SIX_MATCH
import lotto.model.User.Companion.SIX_MATCH_REWARD
import lotto.model.User.Companion.THREE_MATCH
import lotto.model.User.Companion.THREE_MATCH_REWARD
import lotto.util.Util
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ServiceTest {

    @Test
    fun `8000원을 주면 8개의 로또를 줌`() {
        val user = User()
        val input = "8000"
        val expected = giveMoneyForTest(user, input)

        val result = 8

        assertEquals(expected, result)
    }

    @Test
    fun `나의 로또 번호와 당첨 로또 번호를 비교 3개 당첨`() {
        val user = User()
        user.lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val ballMachine = BallMachine()
        ballMachine.winningNumbers = mutableListOf(1, 2, 3, 14, 15, 16)

        val expected = 1

        compareLottoNumber(user, ballMachine)

        val result = user.lottoResult.get(THREE_MATCH)

        assertEquals(expected, result)
    }

    @Test
    fun `나의 로또 번호와 당첨 로또 번호를 비교 4개 당첨`() {
        val user = User()
        user.lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val ballMachine = BallMachine()
        ballMachine.winningNumbers = mutableListOf(1, 2, 3, 4, 15, 16)

        val expected = 1

        compareLottoNumber(user, ballMachine)

        val result = user.lottoResult.get(FOUR_MATCH)

        assertEquals(expected, result)
    }

    @Test
    fun `나의 로또 번호와 당첨 로또 번호를 비교 5개 당첨`() {
        val user = User()
        user.lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val ballMachine = BallMachine()
        ballMachine.winningNumbers = mutableListOf(1, 2, 3, 4, 5, 16)

        val expected = 1

        compareLottoNumber(user, ballMachine)

        val result = user.lottoResult.get(FIVE_MATCH)

        assertEquals(expected, result)
    }

    @Test
    fun `나의 로또 번호와 당첨 로또 번호를 비교 5개, 보너스 1개 당첨`() {
        val user = User()
        user.lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val ballMachine = BallMachine()
        ballMachine.winningNumbers = mutableListOf(1, 2, 3, 4, 5, 16)
        ballMachine.bonusNumber = 6

        val expected = 1

        compareLottoNumber(user, ballMachine)

        val result = user.lottoResult.get(FIVE_AND_BONUS_MATCH)

        assertEquals(expected, result)
    }

    @Test
    fun `나의 로또 번호와 당첨 로또 번호를 비교 6개 당첨`() {
        val user = User()
        user.lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val ballMachine = BallMachine()
        ballMachine.winningNumbers = mutableListOf(1, 2, 3, 4, 5, 6)

        val expected = 1

        compareLottoNumber(user, ballMachine)

        val result = user.lottoResult.get(SIX_MATCH)

        assertEquals(expected, result)
    }

    @Test
    fun `1000원을 투자해서 5등 당첨(5000원) roi구하기`() {
        val user = User().apply {
            money = 1000
            lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }

        val ballMachine = BallMachine().apply {
            winningNumbers = mutableListOf(1, 2, 3, 14, 15, 16)
        }

        compareLottoNumber(user, ballMachine)
        setTotalPrize(user)

        val expected = 500.0
        val result = Util.getRoi(user.money, user.totalPrize)

        assertEquals(expected, result)
    }

    @Test
    fun `1000원을 투자해서 4등 당첨(5000원) roi구하기`() {
        val user = User().apply {
            money = 1000
            lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }

        val ballMachine = BallMachine().apply {
            winningNumbers = mutableListOf(1, 2, 3, 4, 15, 16)
        }

        compareLottoNumber(user, ballMachine)
        setTotalPrize(user)

        val expected = 5000.0
        val result = Util.getRoi(user.money, user.totalPrize)

        assertEquals(expected, result)
    }

    @Test
    fun `1000원을 투자해서 3등 당첨(1500000원) roi구하기`() {
        val user = User().apply {
            money = 1000
            lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }

        val ballMachine = BallMachine().apply {
            winningNumbers = mutableListOf(1, 2, 3, 4, 5, 16)
        }

        compareLottoNumber(user, ballMachine)
        setTotalPrize(user)

        val expected = 150000.0
        val result = Util.getRoi(user.money, user.totalPrize)

        assertEquals(expected, result)
    }

    @Test
    fun `1000원을 투자해서 2등 당첨(30000000원) roi구하기`() {
        val user = User().apply {
            money = 1000
            lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }

        val ballMachine = BallMachine().apply {
            winningNumbers = mutableListOf(1, 2, 3, 4, 5, 16)
            bonusNumber = 6
        }

        compareLottoNumber(user, ballMachine)
        setTotalPrize(user)

        val expected = 3000000.0
        val result = Util.getRoi(user.money, user.totalPrize)

        assertEquals(expected, result)
    }


    @Test
    fun `1000원을 투자해서 1등 당첨(2000000000원) roi구하기`() {
        val user = User().apply {
            money = 1000
            lottoTickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }

        val ballMachine = BallMachine().apply {
            winningNumbers = mutableListOf(1, 2, 3, 4, 5, 6)
        }

        compareLottoNumber(user, ballMachine)
        setTotalPrize(user)

        val expected = 200000000.0
        val result = Util.getRoi(user.money, user.totalPrize)

        assertEquals(expected, result)
    }


    private fun giveMoneyForTest(user: User, input: String): Int {
        val requestMoney = UtilTest().requestMoneyForTest(input)

        user.money = requestMoney

        return user.money / 1000
    }

    fun compareLottoNumber(user: User, ballMachine: BallMachine) {
        user.lottoTickets.forEach { lotto ->
            val matchCount = lotto.getNumbers().count { it in ballMachine.winningNumbers }
            val hasBonusCount = lotto.getNumbers().contains(ballMachine.bonusNumber)

            when (matchCount) {
                3 -> user.setResult(THREE_MATCH)
                4 -> user.setResult(FOUR_MATCH)
                5 -> {
                    if (hasBonusCount) user.setResult(FIVE_AND_BONUS_MATCH)
                    if (!hasBonusCount) user.setResult(FIVE_MATCH)
                }

                6 -> user.setResult(SIX_MATCH)
            }
        }
    }

    fun setTotalPrize(user: User) {
        var totalPrize = 0

        for ((match, count) in user.lottoResult) {
            when (match) {
                THREE_MATCH -> totalPrize += THREE_MATCH_REWARD * count
                FOUR_MATCH -> totalPrize += FOUR_MATCH_REWARD * count
                FIVE_MATCH -> totalPrize += FIVE_MATCH_REWARD * count
                FIVE_AND_BONUS_MATCH -> totalPrize += FIVE_AND_BONUS_MATCH_REWARD * count
                SIX_MATCH -> totalPrize += SIX_MATCH_REWARD * count
            }
        }

        user.totalPrize = totalPrize
    }
}