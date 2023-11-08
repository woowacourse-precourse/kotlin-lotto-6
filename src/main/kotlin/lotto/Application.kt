package lotto

fun main() {
    val lottoTicket = LottoTicket()
    val price = lottoTicket.getPrice()
    val lottoList = lottoTicket.getLottoTickets(price)
    println(lottoTicket.getLottoNumbers())

}