package lotto.domain

import lotto.constants.Constant.Companion.MONEY_UNIT
import lotto.constants.Constant.Companion.START_INDEX
import kotlin.math.round

enum class Reward(val hit: Int, val prize: Int, val isBonus: Boolean) {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    MISS(0, 0, false)
}

fun getReward(
    lottoWrapper: LottoWrapper,
    winningLotto: Lotto,
    bonusNumber: Int
): MutableList<Reward> {
    val rewards = mutableListOf<Reward>()
    for (index in START_INDEX until lottoWrapper.size()) {
        var result = compare(lottoWrapper.get(index), winningLotto, bonusNumber)
        rewards.add(calculateReward(result))
    }
    return rewards
}

// 해당 로또와 당첨 번호를 비교하여 맞은 개수를 구하는 메소드
fun compare(lotto: Lotto, winningLotto: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
    var hit = 0
    var isBonus = false
    val numbers = lotto.getNumbers()
    val winningNumbers = winningLotto.getNumbers()
    for (number in numbers) {
        if (winningNumbers.contains(number)) {
            hit++
        }
    }
    if (numbers.contains(bonusNumber)) {
        isBonus = true
    }
    return Pair(hit, isBonus)
}

// 해당 로또의 맞은 개수, 보너스 유무를 가지고 등수를 계산하는 메소드
fun calculateReward(result: Pair<Int, Boolean>): Reward {
    when (result.first) {
        Reward.FIRST.hit -> return Reward.FIRST
        Reward.FOURTH.hit -> return Reward.FOURTH
        Reward.FIFTH.hit -> return Reward.FIFTH
    }
    if (result.first == Reward.SECOND.hit && result.second) {
        return Reward.SECOND
    }
    if (result.first == Reward.THIRD.hit && !result.second) {
        return Reward.THIRD
    }
    return Reward.MISS
}

fun countReward(rewards: MutableList<Reward>): MutableList<Int> {
    var count = mutableListOf<Int>(0, 0, 0, 0, 0)
    for (reward in rewards) {
        when (reward) {
            Reward.FIRST -> count[0]++
            Reward.SECOND -> count[1]++
            Reward.THIRD -> count[2]++
            Reward.FOURTH -> count[3]++
            Reward.FIFTH -> count[4]++
            else -> continue
        }
    }
    return count
}

fun calculateYield(rewards: MutableList<Reward>, amount: Int): Double {
    var sum = 0
    val divisor = amount * MONEY_UNIT
    for (reward in rewards) {
        sum += reward.prize
    }
    var result = (sum.toDouble() / divisor) * 100
    return round((result * 10)) / 10 // 소수점 둘째 자리에서 반올림
}