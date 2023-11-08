package lotto.view

import lotto.Lotto

class LottoView {
    var lottos: List<Lotto> = listOf()
        private set

    fun update(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        this.lottos = lottos
        lottos.forEach { lotto -> println(lotto) }
        println()
    }
}