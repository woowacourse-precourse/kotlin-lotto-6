package lotto

//사용자 입력을 받아 모델에 전달하고, 모델로부터 받은 결과를 뷰에 전달합니다. 뷰와 모델을 연결하는 역할을 합니다.
class LottoController(private val lottoView: LottoView, private val lotto: Lotto) {
    private fun generateLottoTickets(purchaseAmount: Int): List<Lotto> {
        val numOfTickets = purchaseAmount / 1000
        val lottoTickets = mutableListOf<Lotto>()

        repeat(numOfTickets) {
            val numbers = lotto.generateLottoNumbers()
            val lottoTicket = Lotto(numbers)
            lottoTickets.add(lottoTicket)
        }
        lottoView.displayGeneratedLottoTickets(numOfTickets, lottoTickets)
        return lottoTickets
    }

    private fun getWinningNumbersAndBonus(): Pair<List<Int>, Int> {
        val winningNumbers = lottoView.getWinningNumbersFromUser()
        val bonusNumber = lottoView.getBonusNumberFromUser(winningNumbers)
        return winningNumbers to bonusNumber
    }

    private fun compareTicketsWithWinningNumbers(lottoTickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<Int> {
        return lottoTickets.map { it.matchCount(winningNumbers) }
    }

    private fun calculateWinnings(matchCounts: List<Int>): Map<LottoRank, Int> {
        val winnings = mutableMapOf<LottoRank, Int>()

        for (matchCount in matchCounts) {
            val rank = LottoRank.fromMatchCount(matchCount)
            winnings[rank] = winnings.getOrDefault(rank, 0) + 1
        }

        return winnings
    }


    private fun displayWinningStatistics(winnings: Map<LottoRank, Int>, purchaseAmount: Int) {
        println("\n당첨 통계")
        println("---")

        for (rank in LottoRank.entries) {
            if (rank != LottoRank.NONE) {
                val prize = rank.prize
                val count = winnings.getOrDefault(rank, 0)
                println("${rank.matchCount}개 일치 (${prize}원) - ${count}개")
            }
        }

        val totalPrize = winnings.entries.sumBy { (rank, count) -> rank.prize * count }
        val totalProfitRate = (totalPrize - purchaseAmount).toDouble() / purchaseAmount * 100

        println("총 수익률은 $totalProfitRate%입니다.")
    }

    fun run() {
        val purchaseAmount = lottoView.getPurchaseAmountFromUser()
        val lottoTickets = generateLottoTickets(purchaseAmount)
        val (winningNumbers, bonusNumber) = getWinningNumbersAndBonus()
        val matchCounts = compareTicketsWithWinningNumbers(lottoTickets, winningNumbers, bonusNumber)
        val winnings = calculateWinnings(matchCounts)
        displayWinningStatistics(winnings, purchaseAmount)
    }


}
