package lotto

fun main() {
    var isValidLotto = false
    while (!isValidLotto) {
        isValidLotto = true
        try {
            val myLottoNumbers = InputManagement.inputLottoNumbers()
            val myLotto = Lotto(myLottoNumbers)
        } catch (e: IllegalArgumentException) {
            isValidLotto = false
        }
    }

}
