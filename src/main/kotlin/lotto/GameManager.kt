package lotto

import camp.nextstep.edu.missionutils.Randoms

class GameManager {
    private val inputManager = InputManager()
    private var money = 0
    private var lottoList = ArrayList<Lotto>()

    fun runLottoGame() {
        // 사용자 구입 금액 입력
        money = inputManager.getMoney()
        // 발행 로또 번호 생성
        getLottoTickets(money)
        // 발행 로또 갯수 및 번호 출력
        printPurchaseResult()
    }

    private fun getLottoTickets(money: Int) {
        val numberOfLottoTickets = money / LOTTO_PRICE

        for (i in 1..numberOfLottoTickets) {
            lottoList.add(generateLotto())
        }
    }

    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)

        return Lotto(numbers)
    }

    private fun printPurchaseResult() {
        println()
        println("8개를 구매했습니다.")
        for (lotto in lottoList) {
            println(lotto.getNumbers())
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}