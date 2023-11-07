package lotto

fun main() {
    val input = InputValue()
    val makeLotto = MakeLotto()

    val money = input.inputLottoMoney() // 내가 입력한 돈

    val lottoBunch: MutableList<Lotto> = mutableListOf()

//    val winning = input.inputWinningNumber()    // 당첨 번호 6개
//    val bonus = input.inputBonusNumber(winning) // 보너스 번호 1개
//
//    val winningBonus = WinningAndBonusNumber(winning, bonus)    // 복권 당첨 번호, 보너스 번호 생성

    val lottoCount = makeLotto.calculateCountingLotto(money)    // 로또 개수

    for (count in 1..lottoCount) {
        val lotto = makeLotto.createNonOverlapSixNumbers()

        lottoBunch.add(Lotto(lotto))
    }





}