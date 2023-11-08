package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoController(
    private val
    inputview: InputView = InputView(),
    private val outputview: OutputView = OutputView()
) {
    init {
        val amount: Int = getAmount()
    }

    private fun getAmount(): Int {
        var amount: Int
        while (true) {
            try {
                outputview.amountMessage()
                amount = inputview.inputAmount()
                return amount
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }
    private fun buyLotto(): Lotto{
        val nums: List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(nums.sorted())
    }

    private fun getWinnigNums(): List<Int> {
        var winnigNums: List<Int>
        while(true) {
            try{
                outputview.winningMessage()
                winnigNums = inputview.inputWinningNum()
                return winnigNums
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }
    private fun getBonusNum(winningNumbers: List<Int>): Int {
        var bonusNumber: Int
        while (true) {
            try {
                outputview.bonusMessage()
                bonusNumber = inputview.inputBonusNum()
                if (bonusNumber in winningNumbers)
                    throw IllegalArgumentException("[Error] 보너스 번호는 당첨번호와 겹치지 않는 1부터 45사이의 숫자입니다.")
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }
    private fun getRanks(lottos: List<Lotto>,
                         winningNumbers: List<Int>,
                         bonusNumber: Int): List<Int> {
        var ranks: MutableList<Rank> = mutableListOf()
        lottos.forEach{lotto ->
            ranks.add(lotto.getRank(winningNumbers, bonusNumber))
        }
        var rankCounter: MutableList<Int> = mutableListOf(0,0,0,0,0,0)
        ranks.forEach{rank ->
            when (rank){
                Rank.rank5 -> rankCounter[0] += 1
                Rank.rank4 -> rankCounter[1] += 1
                Rank.rank3 -> rankCounter[2] += 1
                Rank.rank2 -> rankCounter[3] += 1
                Rank.rank1 -> rankCounter[4] += 1
                Rank.rank0 -> doNothing()
            }
        }
        return rankCounter
    }
    fun doNothing() {

    }
    fun getRevenue(ranks: List<Int>): Int {
        val reward = listOf(5, 50, 1500, 30000, 2000000)
        var revenue = 0
        for(i in 0..4) {
            revenue += ranks[i] * reward[i]
        }
        return revenue
    }
}
