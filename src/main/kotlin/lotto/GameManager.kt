package lotto

import camp.nextstep.edu.missionutils.Randoms

class GameManager {
    private val inputManager = InputManager()
    private var money = 0
    private var lottos = ArrayList<Lotto>()
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber = 0

    fun runLottoGame() {
        // 사용자 구입 금액 입력
        money = inputManager.getMoney()
        // 발행 로또 번호 생성
        getLottoTickets(money)
        // 발행 로또 갯수 및 번호 출력
        printPurchaseResult()
        // 당첨 번호 입력 및 저장
        winningNumbers = inputManager.getWinningNumber()
        // 보너스 번호 입력 및 저장
        bonusNumber = inputManager.getBonusNumber()
    }

    private fun getLottoTickets(money: Int) {
        val numberOfLottoTickets = money / LOTTO_PRICE

        for (i in 1..numberOfLottoTickets) {
            lottos.add(generateLotto())
        }
    }

    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)

        return Lotto(numbers.sorted())
    }

    private fun printPurchaseResult() {
        println()
        println("8개를 구매했습니다.")
        for (lotto in lottos) {
            println(lotto.getNumbers())
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}

enum class Ranking(val grade: String, val prizeMoney: Int) {
    FIRST("1등", 2000000000),
    SECOND("2등", 30000000),
    THIRD("3등", 1500000),
    FOURTH("4등", 50000),
    FIFTH("5등", 5000)
}