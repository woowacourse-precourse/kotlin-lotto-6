package lotto
import lottoView.LottoOutPut
import lottoViewModel.ValidInput

fun main() {
    val lottoOutput = LottoOutPut()
    val validInput = ValidInput()
    val purchaseAmount = try {
        validInput.validInputPurchase()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return main()
    }
    lottoOutput.purchaseDetailPrint(purchaseAmount)
}

