package lotto

fun main() {
    val myInputManagement = InputManagement()
    val myLottoNumbers = myInputManagement.inputLottoNumbers()
    val myLotto = Lotto(myLottoNumbers)
}
