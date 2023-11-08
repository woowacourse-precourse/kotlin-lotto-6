package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val ERROR = "[ERROR]"
const val NOT_MULTIPLE_OF_1000_ERROR = " 구입금액은 1000의 배수여야 합니다. 다시 입력해 주세요."

fun main() {
    println("구입금액을 입력해 주세요.")

    val numberOfTickets = getNumberOfTickets( validateInputMoney( getInputMoney() ) )
    println("\n${numberOfTickets}개를 구매했습니다.")

    val tickets = generateAllTickets(numberOfTickets)
    printTickets(tickets)

    var sevenNumbers = getSevenNumbers(getWinningNumbers(), getBonusNumber())
    sevenNumbers = validateSevenNumbers(sevenNumbers)

    val countOfEachGradeResult = getCountOfEachGradeResult(tickets, sevenNumbers)
    printLotteryStats(countOfEachGradeResult, numberOfTickets)

}


fun getInputMoney(): Int {

    return Console.readLine().toInt()
}

fun checkMoneyException(inputMoney: Int) {
    require(inputMoney % 1000 == 0) { throw IllegalArgumentException(ERROR+NOT_MULTIPLE_OF_1000_ERROR) }

}

fun validateInputMoney(inputMoney: Int): Int {
    var isValidInput = false
    var localInputMoney = inputMoney    // 매개변수가 val이므로

    while (!isValidInput) {
        try {
            checkMoneyException(localInputMoney)
            isValidInput = true

        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            localInputMoney = getInputMoney()

        }
    }

    return localInputMoney
}

fun getNumberOfTickets( inputMoney: Int ): Int{

    return inputMoney / 1000
}

fun generateLottoNumbers(): List<Int> {

    return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted<Int>()
}

fun generateAllTickets(numberOfTickets: Int): List<Lotto> {
    val tickets = mutableListOf<Lotto>()
    repeat (numberOfTickets) {
        val numbers = generateLottoNumbers()
        val aTicket = Lotto(numbers)
        tickets.add(aTicket)

    }

    return tickets
}

fun printTickets(tickets: List<Lotto>) {
    for (aTicket in tickets) {
        println(aTicket)

    }
}

fun getWinningNumbers(): MutableList<Int> {
    println("\n당첨 번호를 입력해 주세요.")

    return Console.readLine().split(',').map { it.toInt() }.sorted().toMutableList()
}

fun getBonusNumber(): Int {
    println("\n보너스 번호를 입력해 주세요.")

    return Console.readLine().toInt()
}

fun getSevenNumbers(winningNumbers: MutableList<Int>, bonusNumber: Int): MutableList<Int> {
    winningNumbers.add(bonusNumber)
    val sevenNumbers = winningNumbers

    return sevenNumbers
}

fun checkNumbersException(sevenNumbers: MutableList<Int>) {
    var subsetOfSeven = mutableListOf<Int>()

    for (item in sevenNumbers) {
        // 사용자의 입력이 1 이상 45 이하가 아닌 경우
        if (item < 1 || item > 45) {
            throw IllegalArgumentException("$ERROR 당첨 번호와 보너스 번호 모두 1부터 45까지의 정수만 입력하실 수 있습니다.")
        }
        // 사용자의 입력에서 같은 숫자가 중복될 경우
        if (subsetOfSeven.contains(item)) {
            throw IllegalArgumentException("$ERROR 7자리 숫자는 모두 달라야 합니다.")
        }
        subsetOfSeven.add(item)
    }

}

fun validateSevenNumbers(sevenNumbers: MutableList<Int>): MutableList<Int> {
    var isValidInput = false

    while (!isValidInput) {
        try {
            checkNumbersException(sevenNumbers)
            isValidInput = true

        } catch (e: IllegalArgumentException) {
            println("${e.message}")

            sevenNumbers.clear() // Kotlin에서 함수의 매개변수는 기본적으로 val로 선언되니까 재할당 불가. 그래서 비우고
            sevenNumbers.addAll(getSevenNumbers(getWinningNumbers(), getBonusNumber())) // 새로운 요소들을 추가

        }
    }

    return sevenNumbers
}

fun compareNumbers(aTicketNumbers: List<Int>, sevenNumbers: MutableList<Int>): Int {
    val winningNumbers = sevenNumbers.take(6)
    val bonusNumber = sevenNumbers[6]
    val sizeOfSubset = winningNumbers.toSet().intersect(aTicketNumbers).size

    val releventIndex = when (sizeOfSubset) {
        3 -> 0
        4 -> 1
        5 -> if (!aTicketNumbers.contains(bonusNumber)) 2 else 3
        6 -> 4
        else -> return -1

    }
    return releventIndex

}

fun getCountOfEachGradeResult(tickets: List<Lotto>, sevenNumbers: MutableList<Int>): MutableList<Int> {
    var countOfEachGradeResult= MutableList(5) { 0 }   // 앞부터 5등,4등,3등,2등,1등 개수

    for ( aTicket in tickets ) {
        val aTicketNumbers = aTicket.getNumbers()
        val releventIndex = compareNumbers(aTicketNumbers, sevenNumbers)
        if (releventIndex != -1) {
            countOfEachGradeResult[releventIndex]++
        }
    }

    return countOfEachGradeResult
}

fun printLotteryStats(countOfEachGradeResult: MutableList<Int>, numberOfTickets: Int ) {
    println("\n당첨 통계\n---")
    println("3개 일치 (5,000원) - ${countOfEachGradeResult[0]}개\n" +
            "4개 일치 (50,000원) - ${countOfEachGradeResult[1]}개\n" +
            "5개 일치 (1,500,000원) - ${countOfEachGradeResult[2]}개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ${countOfEachGradeResult[3]}개\n" +
            "6개 일치 (2,000,000,000원) - ${countOfEachGradeResult[4]}개")

    val profitRate = calculateProfitRate(countOfEachGradeResult, numberOfTickets)

    val formedProfitRate = String.format("%.1f", profitRate) + "%"
    println("총 수익률은 ${formedProfitRate}입니다.")
}

fun calculateProfitRate(countOfEachGradeResult: MutableList<Int>, numberOfTickets: Int): Double {
    val profit : Int = 5000 * countOfEachGradeResult[0] + 50000 * countOfEachGradeResult[1] +
            1500000 * countOfEachGradeResult[2] + 30000000 * countOfEachGradeResult[3] +
            2000000000 * countOfEachGradeResult[4]

    val profitRate = profit.toDouble() / ( numberOfTickets * 10)

    return profitRate
}