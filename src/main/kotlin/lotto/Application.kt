package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val purchaseAmount = getPurchaseAmount() // 구입 금액을 입력 받음
    val lottoCount = purchaseAmount / 1000
    val lottos = generateLottos(lottoCount) // 로또 티켓을 생성
    printLottos(lottos) // 로또 티켓 목록 출력
    val winningNumbers = getWinningNumbers() // 당첨 번호를 입력 받음
    val bonusNumber = getBonusNumber(winningNumbers) // 보너스 번호를 입력 받음
}

// 구입 금액를 입력하는 함수
fun getPurchaseAmount(): Int {
    while (true) {
        try {
            println("구입금액을 입력해 주세요.")
            val input = Console.readLine() ?: ""
            val purchaseAmount = input.toIntOrNull()
            if (purchaseAmount == null) { throw IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.") }
            if (purchaseAmount <= 0) { throw IllegalArgumentException("[ERROR] 구입 금액은 1 이상이어야 합니다.") }
            if (purchaseAmount % 1000 != 0) { throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.") }
            return purchaseAmount
        }catch (e: IllegalArgumentException) { println(e.message) }
    }
}

// 주어진 개수만큼 로또 티켓을 생성하는 함수
fun generateLottos(count: Int): List<Lotto> {
    val lottos = mutableListOf<Lotto>()
    repeat(count) {
        while (true) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            val lotto = Lotto(numbers)
            if (lottos.none { it.isSameAs(lotto)}) {
                lottos.add(lotto)
                break
            } else {
                throw IllegalArgumentException("[ERROR] 중복된 로또 번호가 생성되었습니다. 다시 시도해 주세요.")
            }
        }
    }
    return lottos
}

// 로또 티켓 목록을 출력하는 함수
fun printLottos(lottos: List<Lotto>) {
    println("\n${lottos.size}개를 구매했습니다.")
    lottos.forEachIndexed { index, lotto ->
        println("${lotto.numbers.sorted()}")
    }
}

// 당첨번호를 입력하는 함수
fun getWinningNumbers(): List<Int> {
    while (true) {
        try {
            println("\n당첨 번호를 입력해 주세요.")
            val numbers = readNumbers()
            if (numbers.size != 6) { throw IllegalArgumentException("[ERROR] 당첨 번호는 정확히 6개를 입력해야 합니다.") }
            if (numbers.any { it < 1 || it > 45 }) { throw IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.") }
            if (numbers.toSet().size != 6) { throw IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다. 다시 입력해 주세요.") }
            return numbers
        } catch (e: IllegalArgumentException) { println(e.message) }
    }
}

// 사용자로부터 입력 받은 숫자 목록을 파싱하여 리스트로 반환하는 함수
fun readNumbers(): List<Int> {
    val input = Console.readLine()
    return input?.split(",")?.mapNotNull { it.trim().toIntOrNull() } ?: emptyList()
}

// 보너스 번호를 입력하는 함수
fun getBonusNumber(winningNumbers: List<Int>): Int {
    while (true) {
        try {
            println("\n보너스 번호를 입력해 주세요.")
            val input = Console.readLine() ?: ""
            val bonusNumber = input.toIntOrNull()
            if (bonusNumber == null) { throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.") }
            if (bonusNumber < 1 || bonusNumber > 45) { throw IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.") }
            if (winningNumbers.contains(bonusNumber)) { throw IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 중복되었습니다.") }
            return bonusNumber
        } catch (e: IllegalArgumentException) { println(e.message) }
    }
}

data class Result(val prizes: MutableList<Prize> = mutableListOf()) {
    fun addPrize(prize: Prize) {
        prizes.add(prize)
    }
}

// 당첨 등수와 상금
enum class Prize(val matchCount: Int, val prizeName: String, val amount: String) {
    FIRST(6, "1등", "2,000,000,000"),
    SECOND(5, "2등", "30,000,000"),
    THIRD(5, "3등", "1,500,000"),
    FOURTH(4, "4등", "50,000"),
    FIFTH(3, "5등", "5,000")
}