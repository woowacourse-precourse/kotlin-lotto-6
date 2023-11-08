package lotto.view

import lotto.viewmodel.LottoViewModel

class LottoView(private val lottoViewModel: LottoViewModel) {
    fun displayLotto() {
        println("${lottoViewModel.numberOfLotto}개를 구매했습니다.")
        lottoViewModel.lotto.forEach { println(it.toString()) }
    }
}