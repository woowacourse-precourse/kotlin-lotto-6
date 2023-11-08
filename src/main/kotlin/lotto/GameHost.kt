package lotto

import lotto.consts.StringRes
import lotto.createlotto.RandomCreateLotto
import lotto.input.Input
import lotto.input.InputValidateEnum
import lotto.lotto.Lotto
import lotto.lotto.LottoGenerator
import lotto.lotto.winning.WinningNumber
import java.lang.IllegalArgumentException

object GameHost {
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
        println(StringRes.RESULT_MSG)
        println("---")
        Result.getPrintResult(lottos, winningNumber, budget)
    }

    private fun getNumbers(): List<Int>{
        var err = false
        do {
            err = false
            try {
                println(StringRes.NUMBER_MSG)
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
                println(StringRes.BONUS_MSG)
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
            println(StringRes.BUDGET_MSG)
            val budget = Input.getInput(InputValidateEnum.BUDGET).toInt()
            return budget
        }catch (e:IllegalArgumentException){
            println(e.message)
            getBudget()
        }
        return 0
    }
}