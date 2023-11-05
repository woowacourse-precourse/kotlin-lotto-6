package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoShop {
    fun purchaseLottos(inputMoney: Int) : List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(inputMoney / 1000) {
            lottos.add(issueLotto())
        }
        return lottos
    }

    private fun issueLotto(): Lotto {
        return Lotto(generateNumbers())
    }

    private fun generateNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1,45,6)
    }

    fun getMatchingCount(lotto: Lotto, winningLotto: Lotto): Int {
        var count = 0
        for (number in winningLotto.getNumbers()) {
            if (lotto.contains(number)) {
                count++
            }
        }
        return count
    }

    fun isBonusMatch(lotto: Lotto, bonusNumber: Int): Boolean {
        return lotto.contains(bonusNumber)
    }
}