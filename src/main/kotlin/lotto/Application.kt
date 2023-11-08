@file:Suppress("UNREACHABLE_CODE")

package lotto

import lotto.*

fun main() {
    val userInput = UserInput()
    val purchaseAmount = userInput.priceInput()

    print(PrintMessage.INPUT_PRICE.content(purchaseAmount))

    // 사용자가 구입한 로또 세트 생성
    val lottoSets = LottoGenerator.generateMultipleSets(purchaseAmount)
    lottoSets.forEach { lotto ->
        println(lotto.getNumbers())
    }

    // LottoMachine 인스턴스 생성 및 로또 세트 설정
    val lottoMachine = LottoMachine()
    lottoMachine.setLottoDraws(lottoSets) // 여기서 생성한 로또 세트를 설정합니다.

    println(PrintMessage.INPUT_WINNING_NUMBER.content())
    val winningNumbersInput = readLine()!!.trim().split(",").map { it.toInt() }.toSet()
    println("winningNumbersInput: $winningNumbersInput")
    lottoMachine.inputWinningNumbers(winningNumbersInput)

    val bonusNumber = userInput.bonusNumberInput()
    lottoMachine.inputBonusNumber(bonusNumber)

    // 결과 계산
    val results = lottoMachine.calculateResults()
    println("result: $results")

    // PrizeCalculator 인스턴스 생성 및 수익률 계산
    val prizeCalculator = PrizeCalculator(results)

    println(PrintMessage.OUTPUT_WINNING_STATISTICS.content())
    results.forEach { (key, value) ->
        println("$key - ${value}개")
    }

    // 총 상금 계산
    val totalPrize = prizeCalculator.calculateTotalPrize()
    println("총 상금: $totalPrize 원")

    // 수익률 계산
    val profitRate = prizeCalculator.calculateProfitRate(purchaseAmount)
    println("profitRate: ${profitRate}")
    println("총 수익률은 ${"%.2f".format(profitRate)}%입니다.")
}




//    val lottoMachine = LottoMachine()
//    val lottos = lottoMachine.purchaseLottos()
//    println("구매한 로또 번호:")
//    lottos.forEach { println(it) }
//
//    println("지난 주 당첨 번호를 입력해 주세요.")
//    val winningNumbersInput = Console.readLine()?.trim()?.split(",")?.mapNotNull { it.toIntOrNull() } ?: emptyList()
//    val winningNumbers = Lotto(winningNumbersInput)
//
//    println("보너스 볼을 입력해 주세요.")
//    val bonusNumber = Console.readLine()?.toIntOrNull() ?: 0
//
//    // 결과 계산
//    val results = lottoMachine.checkResults(lottos, winningNumbers, bonusNumber)
//    val prizeCalculator = PrizeCalculator(results)
//
//    // 결과 출력
//    println("당첨 통계")
//    println("---------")
//    println("3개 일치 (5,000원)- ${results["3개 일치"]}개")
//    println("4개 일치 (50,000원)- ${results["4개 일치"]}개")
//    println("5개 일치 (1,500,000원)- ${results["5개 일치"]}개")
//    println("5개 일치, 보너스 볼 일치 (30,000,000원)- ${results["5개 일치, 보너스 볼"]}개")
//    println("6개 일치 (2,000,000,000원)- ${results["6개 일치"]}개")
//
//    // 수익률 계산 및 출력
//    val totalPrize = prizeCalculator.calculateTotalPrize()
//    val profitRate = prizeCalculator.calculateProfitRate(purchaseAmount)
//    println("총 수익금은 ${totalPrize}원입니다.")
//    println("구입 금액 대비 수익률은 %.2f%% 입니다.".format(profitRate))
//}




