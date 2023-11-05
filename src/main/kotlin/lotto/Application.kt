package lotto
import lottoView.LottoOutPut
import lottoViewModel.CreateNumbers
import lottoViewModel.ValidInput

fun main() {
  val lottoController = LottoConroller()
  lottoController.printDefaultMent()
  lottoController.printWinningMents()
}

