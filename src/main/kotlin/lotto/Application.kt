package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

enum class Prize(val amount: Int) {
    MATCH_3(5000),
    MATCH_4(50000),
    MATCH_5(1500000),
    MATCH_5_BONUS(30000000),
    MATCH_6(2000000000)
}

fun main() {
    println("구입금액을 입력해 주세요.")
    var buyMoney = readIntInput("")

    var ticketCount = 0
    ticketCount = buyMoney/1000

    println("\n${ticketCount}개를 구매했습니다.")

    val tickets = mutableSetOf<List<Int>>()
    for(i: Int in 1..ticketCount){
        val numbers = Randoms.pickUniqueNumbersInRange(1,45,6)
        numbers.sort()
        tickets.add(numbers)
    }

    for(ticket in tickets){
        print("[")
        print(ticket.joinToString(", "))
        println("]")
    }

    println("\n당첨 번호를 입력해 주세요.")
    var correctNumbers = readIntListInput("")

    println("\n보너스 번호를 입력해 주세요.")
    var bonusNumber = readIntInput("")

    var correct3 = 0
    var correct4 = 0
    var correct5 = 0
    var correct5Bonus1 = 0
    var correct6 = 0

    for (ticket in tickets) {
        val matchingNumbers = ticket.filter { it in correctNumbers!! }

        when (matchingNumbers.size) {
            3 -> correct3++
            4 -> correct4++
            5 -> {
                if (bonusNumber?.toInt() in ticket) {
                    correct5Bonus1++
                } else {
                    correct5++
                }
            }
            6 -> correct6++
        }
    }

    println("\n당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${correct3}개")
    println("4개 일치 (50,000원) - ${correct4}개")
    println("5개 일치 (1,500,000원) - ${correct5}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${correct5Bonus1}개")
    println("6개 일치 (2,000,000,000원) - ${correct6}개")

    val income = Prize.MATCH_3.amount * correct3 +
            Prize.MATCH_4.amount * correct4 +
            Prize.MATCH_5.amount * correct5 +
            Prize.MATCH_5_BONUS.amount * correct5Bonus1 +
            Prize.MATCH_6.amount * correct6

    val incomeRate = ((income.toDouble() / buyMoney!!) * 100)
    println("총 수익률은 ${incomeRate}%입니다.")
}

fun readIntInput(prompt: String): Int {
    while (true) {
        try {
            print(prompt)
            return readLine()?.toInt() ?: throw IllegalArgumentException()
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자를 입력해주세요.")
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 1000의 배수로 입력해주세요.")
        }
    }
}

fun readIntListInput(prompt: String): List<Int> {
    while (true) {
        try {
            print(prompt)
            return readLine()?.split(",")?.map { it.toInt() }
                ?: throw IllegalArgumentException()
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자를 입력해주세요.")
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 1에서 45 사이의 숫자로 입력해주세요.")
        }
    }
}