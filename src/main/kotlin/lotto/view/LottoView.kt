package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.util.Printer
import lotto.util.Reader

class LottoView {

    private val printer = Printer
    private val reader = Reader

    fun readInputMoney(): Int {
        printer.printInputMoney()
        return reader.readLottoMoney()
    }

    fun readInputNumbers(): Lotto {
        printer.printInputNumbers()
        return Lotto(reader.readLottoNumbers())
    }

    fun readInputBonus(lotto: Lotto): Int {
        printer.printInputBonus()
        return reader.readLottoBonus(lotto.getLottoNumbers())
    }

    fun printLottoCount(count: Int) {
        printer.printLottoCount(count)
    }

    fun printGeneratedLotto(lottoList: List<Lotto>) {
        lottoList.forEach { lotto ->
            printer.printGeneratedLotto(lotto.getLottoNumbers())
        }
        println()
    }

    fun printResult(lottoMap: Map<LottoRank, Int>) {
        printer.printResultMessage()
        lottoMap.forEach { map ->
            printer.printResult(map.key.message, map.value)
        }
    }

    fun printProfitRate(rate: Double) {
        printer.printProfitRate(rate)
    }
}