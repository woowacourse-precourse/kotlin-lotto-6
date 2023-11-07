package lotto.view

import lotto.model.Lotto
import lotto.util.Printer
import lotto.util.Reader

class LottoView {

    private val printer = Printer
    private val reader = Reader

    fun readInputMoney(): Long {
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

    fun printLottoCount(count: Long) {
        printer.printLottoCount(count)
    }
}