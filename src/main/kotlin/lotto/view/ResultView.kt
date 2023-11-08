package lotto.view

import lotto.viewmodel.ResultViewModel

class ResultView(private val resultViewModel: ResultViewModel) {
    private fun displayNotice() = println("\n당첨 통계\n---")
    private fun displayResult() = println(resultViewModel.updateResult())
    private fun displayRateOfReturn() = print("총 수익률은 ${resultViewModel.initRateOfReturn()}%입니다.")

    fun displayResultReport() {
        displayNotice()
        displayResult()
        displayRateOfReturn()
    }
}