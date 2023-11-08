package lotto.view

import lotto.domain.Lotto

object OutputView {
    fun printLottosNumbers(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto ->
            printLottoNumbers(lotto)
        }
        println()
    }

    fun printLottoNumbers(lotto: Lotto) {
        val lottoNumbers = lotto.getLottoNumbers()
        print("["+lottoNumbers+"]")
    }
}