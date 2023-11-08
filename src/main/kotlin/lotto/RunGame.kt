package lotto

import camp.nextstep.edu.missionutils.Randoms

class RunGame {
    fun startGame(){
        ComputerOutput().takeOrder()
        var money: Int = UserInput().payMoney()!!
        var numOfLotto: Int? = money / 1000
        ComputerOutput().theNumPurchased(numOfLotto!!)
        var boughtLotto: MutableList<List<Int>> = buyLotto(numOfLotto)
        ComputerOutput().askWinNum()
        var winNum: List<Int> = UserInput().getLotNum()!!
        ComputerOutput().askBonNum()
        var bonNum: Int = UserInput().getBonusNum()!!
        var lottoResult: MutableList<List<Int>> = checkResult(winNum,boughtLotto,bonNum)
        var prize: Int = checkPrize(winNum, bonNum, lottoResult)
        ComputerOutput().winLotto(lottoResult)
        ComputerOutput().staticLotto(money,prize)
    }

    private fun buyLotto(num: Int): MutableList<List<Int>> {
        var numbers: MutableList<List<Int>> = mutableListOf<List<Int>>()
        for (i in 0 until num) {
            numbers.add(makeLotto())
            ComputerOutput().purchasedLotto(numbers[i])
        }
        return numbers
    }

    private fun makeLotto(): List<Int> {
        var lottoNums: MutableList<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return lottoNums.sorted()
    }

    private fun checkResult(wNum: List<Int>, bLotto: MutableList<List<Int>>, bNum: Int): MutableList<List<Int>> {
        var lottoResult: MutableList<List<Int>> = mutableListOf()
        for (i in 0 until bLotto.size) {
            lottoResult.add(Lotto(wNum).checkLotto(bLotto[i], bNum))
        }
        return lottoResult
    }

    private fun checkPrize(wNum: List<Int>, bNum: Int, lResult: MutableList<List<Int>>): Int {
        var prize: Int = 0
        for (i in 0 until lResult.size) {
            prize += Lotto(wNum).checkMoney(lResult[i] as MutableList<Int>, bNum)
        }
        return prize
    }

}