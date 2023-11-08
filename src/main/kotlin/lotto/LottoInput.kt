package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object LottoInput {
    val winingNumbers = mutableListOf<Int>()
    var bonusNumber: Int = 0

    fun putBonusNumber() {
        try {
            println("보너스 번호를 입력해주세요")
            val Text = Console.readLine()
            Validator.convertNumber(Text)
            val number = Text.toInt()
            Validator.range(number)
            Validator.exist(winingNumbers, number)
            bonusNumber = number
        } catch (e: IllegalArgumentException) {
            println(e.message)
            putBonusNumber()
        }
    }

    fun putWiningNumbers() {
        println("당첨 번호를 입력해 주세요.")
        val inputText: String = Console.readLine()
        try {
            inputText.split(",").forEach {
                Validator.range(it.toInt())
                winingNumbers.add(it.toInt())
                Validator.duplication(winingNumbers)
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            winingNumbers.clear()
            putWiningNumbers()
        }
    }

    fun buyLotto(many: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        for (lotto in 1..many) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.add(Lotto(numbers))
        }
        return lottos
    }

}