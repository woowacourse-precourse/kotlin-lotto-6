package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    private var lottoPurchaseAmount: Int = 0
    private var lottoTickets: List<List<Int>> = emptyList()
    private var winningNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = 0

    init {
        require(numbers.size == 6)
    }

    private fun getPurchaseAmount(): Int {
        // 로또 구입 금액이 1000원 단위가 아니면 예외 처리하는 함수
        // 무조건 숫자만 입력 가능하게 테스트 추가하기
        println("구입금액을 입력해 주세요.")
        lottoPurchaseAmount = Console.readLine().toInt()

        if (lottoPurchaseAmount % 1000 != 0) {
            throw IllegalArgumentException()
        }
        return lottoPurchaseAmount
    }

    fun getLottoNumbers() {
        // 발행한 로또 수량 및 번호를 출력한다.
        // 로또 번호는 오름차순으로 정렬하여 보여준다.
        val lottoPurchaseAmount = getPurchaseAmount()
        val numOfTickets = lottoPurchaseAmount / 1000
        println("\n${numOfTickets}개를 구매했습니다.")

        val tickets = mutableListOf<List<Int>>()
        for(i in 1..numOfTickets) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()

            if (hasDuplicateNumbers(numbers)) {
                throw IllegalArgumentException()
            }

            tickets.add(numbers)
            println(numbers)
        }
        lottoTickets = tickets
    }

    private fun hasDuplicateNumbers(numbers: List<Int>): Boolean {
        // 숫자 중복 확인
        return numbers.size != numbers.toSet().size
    }

    fun getWinningNumbers() {
        // 당첨 번호를 입력 받는 함수, 번호는 쉼표 기준으로 구분한다
        println("\n당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine()
        val winningNumberList = winningNumbers.split(",").map { it.toInt() }

        if (winningNumberList.size != 6 || hasDuplicateNumbers(winningNumberList)) {
            throw IllegalArgumentException()
        }

        this.winningNumbers = winningNumberList
    }

    fun getBonusNumber() {
        // 보너스 번호를 입력 받는 함수
        println("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine().toInt()
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException()
        }
        this.bonusNumber = bonusNumber
    }

    fun showWinningNumbers() {
        // 당첨 통계 계산
        val matchingNumbers: List<Int> = lottoTickets.map { ticket ->
            ticket.count { it in winningNumbers }
        }
        val hasBonusNumbers = bonusNumbers()

        // enum class 만들기
        println("\n당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${matchingNumbers.count { it == 3 }}개")
        println("4개 일치 (50,000원) - ${matchingNumbers.count { it == 4 }}개")
        println("5개 일치 (1,500,000원) - ${matchingNumbers.count { it == 5 }}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${hasBonusNumbers.count { it == 5 }}개")
        println("6개 일치 (2,000,000,000원) - ${matchingNumbers.count { it == 6 }}개")
        println("총 수익률은 ${calculateProfit(matchingNumbers)}%입니다.")
    }

    private fun bonusNumbers(): List<Int> {
        val hasBonusNumbers = lottoTickets.map { ticket ->
            if (ticket.contains(bonusNumber)) {
                winningNumbers.intersect(ticket.toSet()).count() - 1
            } else {
                winningNumbers.intersect(ticket.toSet()).count()
            }
        }
        return hasBonusNumbers
    }

    private fun calculateProfit(matchingNumbers: List<Int>): String {
        val match3Numbers = 5000.0
        val match4Numbers = 50000.0
        val match5Numbers = 1500000.0
        val match5NumbersWithBonus = 30000000.0
        val match6Numbers = 2000000000.0

        // 각 등수의 상금과 해당 등수의 로또 티켓 수를 매핑
        val prizeMap = mapOf(
            3 to match3Numbers,
            4 to match4Numbers,
            5 to match5Numbers,
            5 to match5NumbersWithBonus,
            6 to match6Numbers
        )

        // 수익 계산
        val totalPrize = matchingNumbers.mapNotNull { prizeMap[it] }.sum()
        val totalCost = lottoPurchaseAmount.toDouble()
        val profitPercentage = (totalPrize / totalCost) * 100

        return "%.1f".format(profitPercentage)
    }
}


