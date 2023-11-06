package lotto

import kotlin.math.round


enum class Prize(val matchCount: Int, val prize: Int, val bonus: Boolean) {
    FIRST(6, 2000000_000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    MISS(0, 0, false);
}



fun getMatchCount(userLotto: Lotto, lotto: Lotto, bonusNumber: Int ): Pair<Int, Boolean> {
    var matchCount = 0
    var bonus = false
    val numbers = userLotto.getNumbers()
    val userLottoNumbers = lotto.getNumbers()
    for (number in numbers) {
        if (userLottoNumbers.contains(number)) {
            matchCount++
        }
    }
    if (numbers.contains(bonusNumber)) {
        bonus = true
    }
    return Pair(matchCount, bonus)
}
fun getPrize(prizeList: Pair<Int,Boolean>): Prize {

    if (prizeList.first == 3) {
        return Prize.FIFTH
    }
    if (prizeList.first == 4) {
        return Prize.FOURTH
    }
    if (prizeList.first == 5 && !prizeList.second) {
        return Prize.THIRD
    }
    if (prizeList.first == 5 && prizeList.second) {
        return Prize.SECOND
    }
    if (prizeList.first == 6) {
        return Prize.FIRST
    }
    return Prize.MISS
}
fun getPrizeList(prize:MutableList<Prize>): MutableList<Int> {
    val prizeList = mutableListOf(0,0,0,0,0,0)
    for (i in prize) {
        when(i) {
            Prize.FIRST -> prizeList[0]++
            Prize.SECOND -> prizeList[1]++
            Prize.THIRD -> prizeList[2]++
            Prize.FOURTH -> prizeList[3]++
            Prize.FIFTH -> prizeList[4]++
            Prize.MISS -> prizeList[5]++
        }
    }
    return prizeList
}
fun getEarningRate(prizeList: MutableList<Prize>, money: Int): Double {
    var earningRate = 0.0
    var money = 0
    for (prize in prizeList) {
        money += prize.prize
    }
    earningRate = money.toDouble() / money
    return earningRate
}