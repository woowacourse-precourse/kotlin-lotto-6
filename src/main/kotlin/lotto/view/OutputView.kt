package lotto.view

import lotto.domain.Lottos

object OutputView {

    private const val OUTPUT_LOTTO_COUNT = "%d개를 구매했습니다."

    fun outputLottos(lottos: Lottos) {
        println()
        println(OUTPUT_LOTTO_COUNT.format(lottos.size()))
        println(lottos.joinToString(System.lineSeparator()))
    }
}