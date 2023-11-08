package lotto

class CompareLottoNumber(private val purchasedLottoTicket: PurchasedLottos) {
    private var countMatch = IDX_ZERO
    private val bonusNumber = purchasedLottoTicket.getBonusNumber()

    private fun printState() {
        println("당첨 통계")
        println("---")
    }

    fun compareWinningLottoAndPurchasedLotto() {
        printState()

        val userLottos = purchasedLottoTicket.getPurchasedLottos()
        val winningLottoNumber = purchasedLottoTicket.getWinning()

        for (i in IDX_ZERO until userLottos.size) {
            checkMatching(userLottos[i], winningLottoNumber)
        }
    }

    private fun checkMatching(purchasedLotto: Lotto, winningLotto: List<Int>) {
        countMatch = purchasedLotto.getNumbers().count { it in winningLotto }
        when {
            countMatch == 3 -> MatchCatalog.Match3.matchCountPlus()
            countMatch == 4 -> MatchCatalog.Match4.matchCountPlus()
            (countMatch == 5 && checkBonusNumber(purchasedLotto)) -> MatchCatalog.MatchBonus.matchCountPlus()
            countMatch == 5 -> MatchCatalog.Match5.matchCountPlus()
            countMatch == 6 -> MatchCatalog.Match6.matchCountPlus()
        }
    }

    private fun checkBonusNumber(lotto: Lotto): Boolean {
        val lottoNumber = lotto.getNumbers()
        for (i in IDX_ZERO until lottoNumber.size) {
            if (lottoNumber[i] == bonusNumber) {
                return true
            }
        }
        return false
    }
}