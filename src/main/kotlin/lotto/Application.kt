package lotto

import kotlin.text.toInt
import java.util.Random
import lotto.Lotto

// import camp.nextstep.edu.missionutils.Randoms // pickUniqueNumbersInRange()
// import camp.nextstep.edu.missionutils.Console // readLine()
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
            inputPrice = readLine()!!
            price = priceCheck(inputPrice)
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }

    var lottoList = mutableListOf<Lotto>()
    val randomValues = listOf<Int>(1,2,3,4,5,6)

    for(i in 1..price / 1000) {
        lottoList.add(Lotto(randomValues))
    }
    
    lateinit var inputWinNum: String
    lateinit var inputBonusNum: String
    lateinit var winNumList: List<Int>
    var bonusNum = 0

    var checkWinNum: Int = 0
    while (checkWinNum == 0) {
        try {
            println("당첨 번호를 입력해 주세요.")
            inputWinNum = readLine()!!
            winNumList = winNumCheck(inputWinNum)
            checkWinNum = 1
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }
    
    while (bonusNum == 0) {
        try {
            println("보너스 번호를 입력해 주세요.")
            inputBonusNum = readLine()!!
            bonusNum = bonusNumCheck(inputBonusNum)
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }

    val result = Array(6) { 0 }

}

fun winNumCheck(inputWinNum: String): List<Int> {
    val numSplit = inputWinNum.split(",")
    val winNumList = numSplit.map { it.toInt() }
    
    for (num in winNumList) {
        if (num < 1 || num > 45 || winNumList.size != 6) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }
    
    return winNumList
}

fun bonusNumCheck(inputBonusNum: String): Int {
    val bonusNum = inputBonusNum.toInt()
    
    if (bonusNum < 1 || bonusNum > 45) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    
    return bonusNum
}

fun priceCheck(inputPrice: String): Int {
    
    val result =inputPrice.toInt()
    if (result % 1000 == 0) {
        return result
    } else {
        throw IllegalArgumentException("[ERROR] 구입금액을 잘못 입력하였습니다.")
    }
}

