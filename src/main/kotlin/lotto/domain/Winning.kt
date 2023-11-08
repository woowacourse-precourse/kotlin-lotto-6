package lotto.domain

import lotto.Lotto

enum class Winning(val message: String, val match: Int, val prize: Int) {

    THREE("3개 일치 (5,000원) - ", 3, 5000),
    FOUR("4개 일치 (50,000원) - ",4, 50000),
    FIVE("5개 일치 (1,500,000원) - ",5, 1500000),
    BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 5, 30000000),
    SIX("6개 일치 (2,000,000,000원) - ", 6, 2000000000)
}

// 당첨 번호와 로또 번호 비교
fun compareToLotto(lottos: MutableList<Lotto>, winningNumber: List<Int>, BonusNumber: Int): Pair<MutableList<Int>, Int> {
    var bonus = 0
    val matchCount : MutableList<Int> = mutableListOf()
    for(index in lottos.indices) {
        val union = lottos[index].getNumbers() + winningNumber
        val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
        matchCount.add(intersection.size)

        if(intersection.size == 5 && lottos[index].getNumbers().contains(BonusNumber)) {
            bonus++
        }
    }
    return Pair(matchCount, bonus)
}

// 당첨된 횟수 적립
fun matchCheck(matches: Pair<MutableList<Int>, Int>): MutableList<Int> {
    var totalMatch = mutableListOf(0,0,0,0,0)

    for (index in matches.first.indices) {
        when (matches.first[index]) {
            Winning.THREE.match -> totalMatch[0]++
            Winning.FOUR.match -> totalMatch[1]++
            Winning.FIVE.match -> totalMatch[2]++
            Winning.SIX.match -> totalMatch[4]++
        }
    }
    repeat(matches.second) {
        totalMatch[3]++
    }

    return totalMatch
}

// 당첨된 금액 합계
fun getTotalAmount(matches: MutableList<Int>): Int {
    var total = matches[0] * Winning.THREE.prize
    + matches[1] * Winning.FOUR.prize
    + matches[2] * Winning.FIVE.prize
    + matches[3] * Winning.BONUS.prize
    + matches[4] * Winning.SIX.prize

    return total
}

// 수익률 구하기
fun getEarningRate(amount: Int, total: Int): Float {
    val amount = amount.toFloat()
    val total = total.toFloat()
    return (total/amount)*100
}