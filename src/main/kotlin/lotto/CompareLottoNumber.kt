package lotto

class CompareLottoNumber (private val purchasedLottoTicket: PurchasedLottos) {
    private var countMatch = IDX_ZERO
    fun printState() {
        println("당첨 통계")
        println("---")
    }

    fun compareWinningLottoAndPurchasedLotto() {
        val userLottos = purchasedLottoTicket.getPurchasedLottos()
        val winningLottoNumber = purchasedLottoTicket.getWinning()

        for(i in IDX_ZERO until LOTTO_SIZE) {
            checkMatching(userLottos, winningLottoNumber)
        }
    }

    fun checkMatching(list1: MutableList<Lotto>, list2: List<String>): Int {

    }
}