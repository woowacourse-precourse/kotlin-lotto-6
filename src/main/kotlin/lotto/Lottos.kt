package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lottos {
    fun getNumbers(purchaseAmount: Int): Array<List<Int>> {  // 로또 발행(정렬x)
        var sortedLottos = List<Int>(6) { 0 }
        var lottos = Array(purchaseAmount) { List(6) { 1 } }

        for (i in 0 until purchaseAmount) {
            lottos[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos[i] = lottos[i].sorted()  // 오름차순 정렬
        }
        return lottos
    }

    fun printLottos(sortedLottos: Array<List<Int>>) {  // (정렬 후) 로또 출력
        println()
        println("${sortedLottos.size}개를 구입했습니다.")
        for (i in sortedLottos.indices)
            println(sortedLottos[i])
    }

}