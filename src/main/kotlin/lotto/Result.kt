package lotto

class Result {
    fun getPrintResult(lottos: List<Lotto>, winningNumbers: WinningNumber, budget: Int) {
        val winningEnums = enumValues<WinningStrategyEnum>()
        val resultMap = mutableMapOf<WinningStrategyEnum, Int>()
        winningEnums.map {
            resultMap[it] = 0
        }
        for (item in lottos) {
            checkWinning(item, winningNumbers, winningEnums, resultMap)
        }
        print(winningEnums, resultMap)
        calculateAndPrintProfit(winningEnums,resultMap,budget)
    }

    private fun calculateAndPrintProfit(winningEnums: Array<WinningStrategyEnum>, resultMap: MutableMap<WinningStrategyEnum, Int>, budget: Int) {
        var sum = 0
        for (item in winningEnums) {
            sum += item.prize * resultMap[item]!!
        }
        println("총 수익률은 ${(sum.toDouble()/budget.toDouble()*100).toBigDecimal().toPlainString()}%입니다.")
    }

    private fun checkWinning(
        lotto: Lotto,
        winningNumbers: WinningNumber,
        winningEnums: Array<WinningStrategyEnum>,
        resultMap: MutableMap<WinningStrategyEnum, Int>
    ) {
        for (strategy in winningEnums) {
            if (lotto.checkWinning(winningNumbers, strategy)) {
                resultMap[strategy] = resultMap[strategy]!! + 1
                break
            }
        }
    }

    private fun print(winningEnums: Array<WinningStrategyEnum>, resultMap: Map<WinningStrategyEnum, Int>) {
        for (item in winningEnums) {
            println("${item.title} - ${resultMap[item]}개")
        }
    }
}