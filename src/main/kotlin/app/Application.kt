package app

import compareNumber.CompareNumber
import lotto.Lotto
import lotto.LottoInitializer
import winningNumber.BonusNumber
import winningNumber.WinningNumber

fun main() {
    val lotto = LottoInitializer()
    val lottos = mutableListOf<Lotto>()
    val winningNumber = WinningNumber()
    val bonusNumber = BonusNumber()
    val compareNumber = CompareNumber()


    val price = lotto.inputPriceOfLotto()
    val amountOfLotto = price/1000

    //랜덤 번호를 로또번호 리스트로 생성
    for (amount in 0 until amountOfLotto) {
        val numbers = lotto.makeLottoNumber()
        lottos.add(Lotto(numbers))
    }

    //구매한 로또 리스트 출력
    for(lotto in 0 until lottos.size) {
        println(lottos[lotto].getNumbers())
    }

    var onlyWinningNumber = winningNumber.inputWinningNumber()
    var addBonusNumber = bonusNumber.inputBonusNumber(onlyWinningNumber)

    var ranks = compareNumber.resultOfLotto(lottos,addBonusNumber)
    compareNumber.showResult(ranks)
}
