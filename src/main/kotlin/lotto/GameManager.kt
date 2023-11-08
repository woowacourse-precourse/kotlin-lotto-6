package lotto

import camp.nextstep.edu.missionutils.Randoms

class GameManager {
    private val inputManager = InputManager()
    private var money = 0
    private var lottos = ArrayList<Lotto>()
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber = 0

    // 로또 게임 진행
    fun runLottoGame() {
        money = inputManager.getMoney()
        getLottoTickets(money)
        printPurchaseResult()
        winningNumbers = inputManager.getWinningNumber()
        bonusNumber = inputManager.getBonusNumber()
    }


    // 사용자 급액에 따른 발행 로또 발행 및 번호 생성
    private fun getLottoTickets(money: Int) {
        val numberOfLottoTickets = money / LOTTO_PRICE

        for (i in 1..numberOfLottoTickets) {
            lottos.add(generateLotto())
        }
    }

    // 로또 한 장 발행
    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)

        return Lotto(numbers.sorted())
    }


    // 발행 로또 갯수 및 번호 출력
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