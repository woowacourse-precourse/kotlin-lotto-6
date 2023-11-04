package lotto

import camp.nextstep.edu.missionutils.*

fun main() {
    println("구입금액을 입력해 주세요.")
    val purchasePrice = Console.readLine().toInt()
    //금액이 숫자가 아닌 경우, 범위를 초과하는 경우 예외처리, under 1000

    val purchaseAmount = purchasePrice / 1000

    val tmpLottoList = mutableListOf<Lotto>()

    for(i in 0 until purchaseAmount){
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val tmpLotto = Lotto(numbers)
        tmpLottoList.add(tmpLotto)
    }

    val lottoList : List<Lotto> = tmpLottoList

    println("\n${purchaseAmount}개를 구매했습니다.")
    for(i in 0 until purchaseAmount){
        println(lottoList[i].getLottoNumberString())
    }

    println("\n당첨 번호를 입력해 주세요.")
    val winningNumbers = readln().split(',').map { it.toInt() }
    //예외처리

    println("\n보너스 번호를 입력해 주세요.")
    val bonusNumber = readln().toInt()
    //예외처리

    println("\n당첨 통계")
    println("---")

    val winningList = HashMap<Int, Int>()
    val winningPrice = listOf<String>("0", "2,000,000,000", "30,000,000", "1,500,000", "50,000", "5,000")
    val winningPriceInt = listOf<Int>(0,2000000000,30000000,1500000,50000,5000)
    for(i in 0 ..< 6) winningList[i] = 0

    lottoList.forEach {
        winningList[it.getRank(winningNumbers, bonusNumber)] = winningList[it.getRank(winningNumbers, bonusNumber)]!! + 1
    }

    for(i in 5 downTo 1){
        println("${i}개 일치 (${winningPrice[i]}원) - ${winningList[i]}개")
    }

    var totalWinningPrice = 0.0

    for(i in 1 ..< 6){
        totalWinningPrice += winningPriceInt[i]* winningList[i]!!
    }

    val rate = totalWinningPrice/(10*purchaseAmount)

    println("총 수입률은 ${String.format("%.1f", rate)}%입니다.")
}
