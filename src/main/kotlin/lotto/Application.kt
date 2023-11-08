package lotto

fun main() {
    val lottoTicket = LottoTicket()
    val price = lottoTicket.getPrice()
    val lottoList = lottoTicket.getLottoTickets(price)
    val lotto = Lotto(lottoTicket.getLottoNumbers())
    lotto.printLottoNumbers()
    lotto.getBonusNumber()

}