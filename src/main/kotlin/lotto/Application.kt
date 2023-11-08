package lotto

fun main() {
    val input = InputValue()
    val makeLotto = MakeLotto()
    val calculator = Calculator()

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
    val winningNumber = Lotto(winning)    // 복권 당첨 번호, 보너스 번호 생성

    println("당첨 통계")
    println("---")

    val rank: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0)

    for (lotto in lottoBunch) {
        val winCount = lotto.compareCountingMatchedWinningNumber(winningNumber)
        val bonusCount = lotto.compareCountingMatchedBonusNumber(bonus)

        rank[lotto.divideStandard1to6(winCount, bonusCount)] += 1
    }

    println("3개 일치 (5,000원) - ${rank[0]}개")
    println("4개 일치 (50,000원) - ${rank[1]}개")
    println("5개 일치 (1,500,000원) - ${rank[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${rank[3]}개")
    println("6개 일치 (2,000,000,000원) - ${rank[4]}개")

    println("총 수익률은 ${calculator.calculateRateReturn(rank, money)}%입니다.")
}