package lotto

fun main() {
    val lottoTicket = LottoTicket()

    val (lottoList, price) = lottoTicket.getLottoListAndPrice()

    val lotto = Lotto(lottoTicket.getLottoNumbers())

    lotto.printLottoNumbers()

    lotto.getBonusNumber()

    lotto.lottoLogic(lottoList, price)
}