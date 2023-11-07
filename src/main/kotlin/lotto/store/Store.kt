package lotto.store

import camp.nextstep.edu.missionutils.Console
import lotto.exception.LottoException
import lotto.store.clerk.LottoClerk
import lotto.store.machine.Machine
import java.math.BigDecimal
import java.util.regex.Pattern

class Store(
        private val lottoClerk: LottoClerk,
        private val machine: Machine
) {


    private var bonusNumber = 0
    private var winLotto = listOf<Int>()
    fun startLotto() {
        var amount = ""
        //TODO amount 1000으로 안나눠질떄 exception
        while(true) {
            amount = Console.readLine()
            if (isDigit(amount)) break
            println("[ERROR] 금액은 숫자만 입력 가능 합니다.")
        }

        val count = lottoClerk.publishLottoCount(BigDecimal(amount))

        val lottos = Console.readLine()
        bonusNumber = Console.readLine().toInt()
        winLotto = lottos.split(",").map { it.toInt() }

        val lottoList = machine.makeRandomLotto(count)
        lottoList.forEach {lotto ->
            println("[${lotto[0]}, ${lotto[1]}, ${lotto[2]}, ${lotto[3]}, ${lotto[4]}, ${lotto[5]}]")
        }

        val benefit = machine.calculateWinResult(lottoList, winLotto, bonusNumber)
        lottoClerk.tellTheResultToCustomer(benefit)
    }

    private fun isDigit(input: String): Boolean {
        return Pattern.matches("^[0-9]*\$", input)
    }
}