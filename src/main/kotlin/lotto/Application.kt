package lotto

import lotto.Lotto
import camp.nextstep.edu.missionutils.Randoms // pickUniqueNumbersInRange()
import camp.nextstep.edu.missionutils.Console // readLine()
import kotlin.math.*

enum class Rank {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    BOOM
}
fun main() {
    
    
    lateinit var inputPrice: String
    var price  = 0
    
    while (price == 0) {
        try {
            println("구입금액을 입력해 주세요.")
            inputPrice = Console.readLine()
            price = priceCheck(inputPrice)
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }
    println()

    var lottoList = mutableListOf<Lotto>()

    for(i in 1..price / 1000) {
        val randomPickNum = makeLottoNum()
        randomPickNum.sorted()
        lottoList.add(Lotto(randomPickNum))
    }
    
    println("${price / 1000}개를 구매했습니다.")
    for (lotto in lottoList) {
        println(lotto.getNum())
    }
    println()

    lateinit var inputWinNum: String
    lateinit var inputBonusNum: String
    lateinit var winNumList: List<Int>
    var bonusNum = 0

    var checkWinNum: Int = 0
    while (checkWinNum == 0) {
        try {
            println("당첨 번호를 입력해 주세요.")
            inputWinNum = Console.readLine()
            winNumList = winNumCheck(inputWinNum)
            checkWinNum = 1
            println()
        } catch (e: IllegalArgumentException) {
            println(e)
        } 
    }
    
    while (bonusNum == 0) {
        try {
            println("보너스 번호를 입력해 주세요.")
            inputBonusNum = Console.readLine()
            bonusNum = bonusNumCheck(inputBonusNum,winNumList)
            println()
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }

    val result = Array(6) { 0 }
    
    for (lotto in lottoList) {
        result[lotto.compareNumber(winNumList, bonusNum)] += 1    
    }

    val totalRevenue = calRevenue(result)
    
    val rate = (totalRevenue * 100) / price

    println("당첨통계\n---")
    println("3개 일치 (5,000원) - ${result[4]}개")
    println("4개 일치 (50,000원) - ${result[3]}개")
    println("5개 일치 (1,500,000원) - ${result[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[1]}개")
    println("6개 일치 (2,000,000,000원) - ${result[0]}개")
    println("총 수익률은 ${round(rate * 10) / 10}%입니다.")

}

fun calRevenue(result: Array<Int>): Double {

    var total: Double = 0.0

    total += result[0] * 2000000000
    total += result[1] * 30000000
    total += result[2] * 1500000
    total += result[3] * 50000
    total += result[4] * 5000

    return total
}

fun winNumCheck(inputWinNum: String): List<Int> {
    val numSplit = inputWinNum.split(",")
    val winNumList = numSplit.map { it.toInt() }
    
    for (num in winNumList) {
        if (num < 1 || num > 45 || winNumList.size != 6) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }

        if (winNumList.size != winNumList.toSet().size) {
            throw IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.")
        }
    }
    
    return winNumList
}

fun bonusNumCheck(inputBonusNum: String, winNumList: List<Int>): Int {
    try {
        inputBonusNum.toInt()
    } catch(e: NumberFormatException) {
        throw IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    val bonusNum = inputBonusNum.toInt()
    if (bonusNum < 1 || bonusNum > 45 || winNumList.contains(bonusNum) ) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    
    return bonusNum
}

fun priceCheck(inputPrice: String): Int {
    
    try {
        inputPrice.toInt()
    } catch(e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 구입금액을 잘못 입력하였습니다.")
    }

    if (inputPrice.toInt() % 1000 == 0) {
        return inputPrice.toInt()
    } else {
        throw IllegalArgumentException("[ERROR] 구입금액을 잘못 입력하였습니다.")
    }
}

fun makeLottoNum(): List<Int> {
    
    lateinit var randomPickNum: List<Int>
    var success = 0
    while (success == 0) {
        try {
            randomPickNum = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            success = duplCheck(randomPickNum)
            
        } catch (e: IllegalStateException) {
            println(e)
        }
        
    }

    return randomPickNum
}

fun duplCheck(randomPickNum: List<Int>): Int {
    if (randomPickNum.size == randomPickNum.toSet().size) {
        return 1
    } else {
        throw IllegalStateException("[ERROR] 로또번호가 중복되었습니다.")
    }
}

