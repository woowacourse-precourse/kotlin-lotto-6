package lotto

import java.lang.IllegalArgumentException

class GameHost {
    fun start() {
        val lottoGenerator = LottoGenerator(RandomCreateLotto())
        val budget = getBudget()
        val lottos = lottoGenerator.createLottos(budget)
        println("${lottos.size}개를 구매했습니다.")
        printLottos(lottos)
        println()
        val numbers = getNumbers()
        val bonus = getBonus()
        println()
        printResult(lottos, WinningNumber(numbers,bonus), budget)
    }

    private fun printResult(
        lottos: List<Lotto>,
        winningNumber: WinningNumber,
        budget: Int
    ) {
        val result = Result()
        println("당첨 통계")
        println("---")
        result.getPrintResult(lottos, winningNumber, budget)
    }

    private fun getNumbers(): List<Int>{
        var err = false
        do {
            err = false
            try {
                println("당첨 번호를 입력해 주세요.")
                val numbers = Input.getInput(InputValidateEnum.WINNING_NUMBER).split(",").map { it.trim().toInt() }
                println()
                return numbers
            } catch (e: IllegalArgumentException) {
                err = true
                println(e.message)
            }
        }while(err)
        return emptyList()
    }

    private fun getBonus() :Int{
        var err = false
        do{
            err = false
            try{
                println("보너스 번호를 입력해 주세요.")
                val bonus = Input.getInput(InputValidateEnum.BONUS).toInt()
                println()
                return bonus
            }catch (e:IllegalArgumentException){
                err = true
                println(e.message)
            }
        }while (err)
        return 1
    }

    private fun printLottos(lottos: List<Lotto>) {
        for (item in lottos) {
            println(item)
        }
    }

    private fun getBudget(): Int {
        try {
            println("구매 금액을 입력해 주세요.")
            val budget = Input.getInput(InputValidateEnum.BUDGET).toInt()
            return budget
        }catch (e:IllegalArgumentException){
            println(e.message)
            getBudget()
        }
        return 0
    }
}