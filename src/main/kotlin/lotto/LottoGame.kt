package lotto

class LottoGame(private val purchaseAmount: Int) {
    private val lottoTickets = mutableListOf<Lotto>()

    init {
        if (purchaseAmount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.")
        }
    }

    fun purchaseLottoTickets() {
        val numberOfTickets = purchaseAmount / 1000
        repeat(numberOfTickets) {
            lottoTickets.add(LottoGenerator.generateLottoTicket())
        }
    }

    fun checkResults(winningNumbers: List<Int>, bonusNumber: Int): LottoResult {
        val results = mutableListOf<Int>()
        for (lotto in lottoTickets) {
            val matchingNumbers = lotto.numbers.intersect(winningNumbers).count()
            results.add(matchingNumbers)
        }
        return LottoResult(results, bonusNumber, purchaseAmount)
    }

    fun getLottoTickets(): List<Lotto> {
        return lottoTickets
    }
}
