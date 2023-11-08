package lotto

fun main() {
    val myInputManagement = InputManagement()
    var isValidLotto = false
    while (!isValidLotto) {
        isValidLotto = true
        try {
            myInputManagement.inputLottoNumbers()
            val myLotto = Lotto(myInputManagement.lottoNumbers)
        } catch (e: IllegalArgumentException) {
            isValidLotto = false
        }
    }
}
