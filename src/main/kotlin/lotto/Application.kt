package lotto
import lottoView.LottoOutPut
import lottoViewModel.ValidInput

fun main() {
    val lottoOutput = LottoOutPut()
    val validInput= ValidInput()
    val lotto = Lotto(emptyList())
    val purchaseAmount = try {
        validInput.validInputPurchase()
    }catch (e:IllegalArgumentException){
       println(e.message)
        return main()
    }
    lottoOutput.purchaseDetailPrint(purchaseAmount)
    val generatedLottoNumbers = lotto.reCreateRandomNumber(purchaseAmount)

    for (numbers in generatedLottoNumbers) {
        println(numbers.joinToString(", "))
    }
}

