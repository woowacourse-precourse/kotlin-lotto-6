package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.model.LottoWinningNumber
import lotto.data.model.UserLottoState

object GameUtils {
    fun divideByThousand(price: Int) = price.div(1000)
    private fun Double.multiplyByThousand() = this.times(1000)
    private fun Double.multiplyByHundred() = this.times(100)
    fun parseToInt(num: String) = num.split(",").map { it.trim().toInt() }

    // 최종 통계
    fun totalStatistics(lottoState: UserLottoState, winningNumber: LottoWinningNumber): UserLottoState {
        lottoState.lottoTickets.forEach { lottoTicket ->
            val matchedNumbers = lottoTicket intersect winningNumber.lottoNumbers.toSet()
            val bonusMatched = winningNumber.bonusNumber in lottoTicket
            when (matchedNumbers.size) {
                6 -> lottoState.firstPrizeCount++
                5 -> if (bonusMatched) lottoState.secondPrizeCount++ else lottoState.thirdPrizeCount++
                4 -> lottoState.fourthPrizeCount++
                3 -> lottoState.fifthPrizeCount++
            }
        }
        return calculateTotalPrizeRate(lottoState)
    }

    fun calculateTotalPrizeRate(lottoState: UserLottoState): UserLottoState {
        return lottoState.apply {
            this.totalPrizeAmount = calculateTotalPrize(lottoState)
            this.totalPrizeRate = parseToRate(totalPrizeAmount.toDouble(), lottoState.lottoTickets.size)
        }
    }

    private fun calculateTotalPrize(lottoState: UserLottoState) =
        (lottoState.firstPrizeCount * PrizeType.getPrice(PrizeType.FIRST.name)
                + lottoState.secondPrizeCount * PrizeType.getPrice(PrizeType.SECOND.name)
                + lottoState.thirdPrizeCount * PrizeType.getPrice(PrizeType.THIRD.name)
                + lottoState.fourthPrizeCount * PrizeType.getPrice(PrizeType.FOURTH.name)
                + lottoState.fifthPrizeCount * PrizeType.getPrice(PrizeType.FIFTH.name))

    private fun parseToRate(prize: Double, size: Int): Double =
        (prize / size.toDouble().multiplyByThousand()).multiplyByHundred()

    // 로또 생성
    fun generateLotto(count: Int): List<List<Int>> {
        val lottoNumbersList = mutableListOf<List<Int>>()
        for (i in 1..count) {
            lottoNumbersList.add(generateLottoNumbers())
        }
        return lottoNumbersList
    }

    // 6자리 랜덤번호 생성
    private fun generateLottoNumbers(): List<Int> {
        val num = Randoms.pickUniqueNumbersInRange(
            CommonConst.GENERATE_LOTTO_NUMBERS_MIN,
            CommonConst.GENERATE_LOTTO_NUMBERS_MAX,
            CommonConst.GENERATE_LOTTO_NUMBERS_COUNT
        )
        return sortLottoNumbers(num)
    }

    // 오름차순 정렬 함수
    private fun sortLottoNumbers(input: List<Int>): List<Int> {
        return input.sorted()
    }

}