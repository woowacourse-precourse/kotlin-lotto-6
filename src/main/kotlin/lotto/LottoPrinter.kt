package lotto

class LottoPrinter {
    fun showLottoList(lottoCount: Int, lottoList: Lotto) {
        println(LottoGameMessage.LOTTO_NUMBER.format(lottoCount))
        lottoList.forEach { lotto -> println(lotto.lottoNumberToString()) }
    }
}