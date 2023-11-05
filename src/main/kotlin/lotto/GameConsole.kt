package lotto

class GameConsole {
    fun printLottoTicket(lottoTickets: List<Lotto>, count: Int) {
        println("\n$count" + PURCHASE_RESULT_MSG)
        for (lotto in lottoTickets) {
            println(lotto)
        }
    }

    companion object {
        const val PURCHASE_RESULT_MSG = "개를 구매했습니다."
    }
}