package lotto

fun main() {
    val myLottoStatus = LottoStatus()
    val myTargetLotto = TargetLottoStatus()
    myLottoStatus.buyUntilValid()
    myTargetLotto.inputTargetLotto()
}
