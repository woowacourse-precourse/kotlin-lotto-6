package lotto

class LottoGamePrinter {
    fun showLottoList(lottoCount: Int, lottoList: List<Lotto>) {
        println(LottoGameMessage.LOTTO_NUMBER.format(lottoCount))
        lottoList.forEach { lotto -> println(lotto.lottoNumberToString()) }
    }
}