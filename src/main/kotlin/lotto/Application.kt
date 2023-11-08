package lotto

import controller.Controller
import lottonumbercomparator.LottoNumberComparatorImpl
import lottonumbergenerator.LottoNumberGeneratorImpl

fun main() {
    Controller(
        LottoNumberGeneratorImpl(),
        LottoNumberComparatorImpl()
    ).startLotto()
}
