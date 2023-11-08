package lotto.model.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.domain.Lotto
import lotto.model.domain.Rank
import lotto.model.domain.WinningLotto
import java.text.DecimalFormat

class Service {
    fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    fun generateLottos(count: Int): List<Lotto> {
        val lottoList: MutableList<Lotto> = mutableListOf()
        for (i in 1..count) {
            lottoList.add(generateLotto())
        }
        return lottoList
    }

    fun generateWinningLottoFromInput(numbers: List<Int>, bonusNumber: Int): WinningLotto {
        return WinningLotto(Lotto(numbers), bonusNumber)
    }

    fun generateWinningLotto(): WinningLotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val bonusNumber: Int = Randoms.pickNumberInList((1..45).toList().minus(numbers))
        return WinningLotto(Lotto(numbers), bonusNumber)
    }

    fun compareLotto(winningLotto: WinningLotto, lotto: Lotto): Rank {
        val hitList: List<Boolean> = lotto.numbers.map { it in winningLotto.lotto.numbers }
        val hitBonus: Boolean = winningLotto.bonusNumber in lotto.numbers
        return when (hitList.count { it == true }) {
            6 -> Rank.FIRST
            5 -> if (hitBonus) Rank.SECOND else Rank.THIRD
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> Rank.MISS
        }
    }

    fun printResultToString(rankList: List<Rank>, inputMoney: Int): Unit {
        println("---")
        println("${Rank.FIFTH.toString()} - ${rankList.count { it == Rank.FIFTH }} 개")
        println("${Rank.FOURTH.toString()} - ${rankList.count { it == Rank.FOURTH }} 개")
        println("${Rank.THIRD.toString()} - ${rankList.count { it == Rank.THIRD }} 개")
        println("${Rank.SECOND.toString()} - ${rankList.count { it == Rank.SECOND }} 개")
        println("${Rank.FIRST.toString()} - ${rankList.count { it == Rank.FIRST }} 개")
        val totalMoney = rankList.map { it.getMoney() }.sum()
        println("총 수익률은 ${DecimalFormat("#.##").format((totalMoney.toDouble() / inputMoney.toDouble()) * 100)}%입니다.")
        println("---")
    }
}