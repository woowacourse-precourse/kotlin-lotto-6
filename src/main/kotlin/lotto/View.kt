package lotto

import camp.nextstep.edu.missionutils.Console

class View {

    fun inputPayment(): Payment {
        while (true) {
            println("구입금액을 입력해 주세요.")
            val input = Console.readLine()
            try {
                return Payment(input)
            } catch (e: IllegalArgumentException) {
                printErrorMessage(e)
                continue
            }
        }
    }

    fun inputLottoNumber(): Lotto {
        while (true) {
            println("\n당첨 번호를 입력해 주세요.")
            val input = Console.readLine()
            val number = input.split(",").sorted()
            try {
                return Lotto(number.map { it.toInt() })
            } catch (e: IllegalArgumentException) {
                printErrorMessage(e)
                continue
            }
        }
    }

    fun inputBonusLottoNumber(inputLottoNumber: Lotto): BonusNumber {
        while (true){
            println("\n보너스 번호를 입력해 주세요.")
            val input = Console.readLine()
            try {
                return BonusNumber(input, inputLottoNumber)
            } catch (e: IllegalArgumentException){
                printErrorMessage(e)
                continue
            }
        }
    }

    private fun printErrorMessage(e: IllegalArgumentException) {
        println("${e.message}\n")
    }

    fun printLotto(lotto: List<Lotto>) {
        println("\n${lotto.size}개를 구매했습니다.")
        lotto.forEach {
            println(it.getLottoNumbers())
        }
    }

    fun printPrizeResult(prize: Prize) {
        println("\n당첨 통계\n---")
        println("3개 일치 (5,000원) - ${prize.fifth}개")
        println("4개 일치 (50,000원) - ${prize.fourth}개")
        println("5개 일치 (1,500,000원) - ${prize.third}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${prize.second}개")
        println("6개 일치 (2,000,000,000원) - ${prize.first}개")
    }

    fun printWinRate(winRate: Double) {
        val rateFormat = String.format("%.1f", winRate)
        println("총 수익률은 ${rateFormat}%입니다.")
    }

    companion object {

    }
}
