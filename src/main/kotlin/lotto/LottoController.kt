package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoController(private val view: ScreenView) {
    fun pickRandomNums(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).toMutableList()
        val lotto = Lotto(toAscending(numbers))
        return lotto
    }

    fun toAscending(unsorted: MutableList<Int>): MutableList<Int> {
        unsorted.sort()
        return unsorted
    }

    fun buyLottos(quantity: Int): Lottos{
        val lottos = Lottos()
        for (i in 1..quantity){
            lottos.add(pickRandomNums())
        }
        return lottos
    }

    fun checkBonusNum(answerLotto: Lotto, bonusNum: BonusNum){
        if (answerLotto.getNumbers().contains(bonusNum.getBonusNum())){
            throw IllegalArgumentException("[ERROR] 당첨 번호 안에 있는 숫자를 보너스 번호로 입력하셨습니다.")
        }
    }

    fun countEqualNums(answer: List<Int>, input: List<Int>): Int {
        var count = 0
        input.forEach {
            if (answer.contains(it)) {
                count++
            }
        }
        return count
    }

    fun countWinningNums(lottos: Lottos, answer: Lotto, bonusNum: BonusNum, result: LottoResult){
        lottos.lottos.forEach{
            var count = countEqualNums(answer.getNumbers(), it.getNumbers())
            var bonus = false
            if (count == 5 && it.getNumbers().contains(bonusNum.getBonusNum())){
                bonus = true
            }
            checkWinningNums(count, bonus, result)
        }
    }

    fun checkWinningNums(count: Int, bonus: Boolean, result: LottoResult) {
        when(count){
            Winning.FIFTH.winningCount -> result.win[0]++
            Winning.FOURTH.winningCount -> result.win[1]++
            Winning.THIRD.winningCount -> if(!bonus) {result.win[2]++}
            Winning.SECOND.winningCount -> if(bonus) {result.win[3]++}
            Winning.FIRST.winningCount -> result.win[4]++
        }
    }

    fun calculateRateOfReturn(result: LottoResult, inputMoney: Int){
        var rateOfReturn = 0.0
        rateOfReturn += result.win[0] * Winning.FIFTH.winningMoney
        rateOfReturn += result.win[1] * Winning.FOURTH.winningMoney
        rateOfReturn += result.win[2] * Winning.THIRD.winningMoney
        rateOfReturn += result.win[3] * Winning.SECOND.winningMoney
        rateOfReturn += result.win[4] * Winning.FIRST.winningMoney
        rateOfReturn /= inputMoney
        rateOfReturn *= 100
        result.rateOfReturn = rateOfReturn
    }
    enum class Winning(val winningCount: Int, val winningMoney: Int) {
        FIFTH(3, 5000),
        FOURTH(4, 50000),
        THIRD(5, 1500000),
        SECOND(5, 30000000),
        FIRST(6, 2000000000)
    }
}