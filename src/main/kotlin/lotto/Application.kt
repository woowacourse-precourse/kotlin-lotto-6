package lotto

fun main() {
    val input = InputValue()
    val makeLotto = MakeLotto()

    println("구입금액을 입력해 주세요.")
    val money = input.inputLottoMoney() // 내가 입력한 돈

    val lottoCount = makeLotto.calculateCountingLotto(money)    // 로또 개수
    println("${lottoCount}개를 구매했습니다.")

    val lottoBunch: MutableList<Lotto> = mutableListOf()

    for (count in 1..lottoCount) {
        val lotto = makeLotto.createNonOverlapSixNumbers()

        println(lotto)

        lottoBunch.add(Lotto(lotto))
    }
    println()

    println("당첨 번호를 입력해 주세요.")
    val winning = input.inputWinningNumber()    // 당첨 번호 6개
    println()
    println("보너스 번호를 입력해 주세요.")
    val bonus = input.inputBonusNumber(winning) // 보너스 번호 1개
    println()
    val winningBonus = WinningAndBonusNumber(winning, bonus)    // 복권 당첨 번호, 보너스 번호 생성

    println("당첨 통계")
    println("---")
    for (lotto in lottoBunch) {

        println(lotto.compareCountingMatchedWinningNumber(winningBonus))
        println(lotto.compareCountingMatchedBonusNumber(winningBonus))

    }



}