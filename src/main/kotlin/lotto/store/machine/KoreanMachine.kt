package lotto.store.machine

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.store.clerk.KoreanLottoClerk
import java.text.DecimalFormat
import java.text.NumberFormat

class KoreanMachine: Machine {
    override fun makeRandomLotto(count: Int): List<List<Int>> {
        val lottoList = mutableListOf<List<Int>>()

        for (loop in 0..<count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            numbers.sort()
            lottoList.add(numbers)
        }

        return lottoList
    }

    override fun calculateWinResult(lottoList: List<List<Int>>, winNumber: List<Int>, bonusNumber: Int): Float {
        val lottoMap = hashMapOf<String, Int>()
        var totalWinningMoney = 0F
        val inputMoney = lottoList.size * (KoreanLottoClerk.LOTTO_PRICE.toFloat())

        lottoList.forEach { lotto ->
            val lottoResult = Lotto(lotto).confirmLottoResult(winNumber, bonusNumber)
            lottoMap[lottoResult] = lottoMap[lottoResult]?.plus(1) ?: 1
        }

        LottoResult.values().forEach { lottoResult ->
            printLottoResult(lottoResult.name, lottoMap[lottoResult.name] ?: 0)
            totalWinningMoney = totalWinningMoney.plus(lottoResult.winnings.toLong() * (lottoMap[lottoResult.name] ?: 0))
        }

        return totalWinningMoney / inputMoney * 100
    }
    private fun printLottoResult(result: String, count: Int) {
        val lottoResult = LottoResult.valueOf(result)
        //TODO 예외 추가 혹은 테스트
        print("${lottoResult.matchCount}개 일치")
        if (lottoResult == LottoResult.SECOND) print(", 보너스 볼 일치")
        println(" (${DecimalFormat("#,###").format(lottoResult.winnings)}원) - $count" + "개")
    }
}