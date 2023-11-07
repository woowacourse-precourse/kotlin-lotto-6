package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lottos {
    fun getNumbers(purchaseAmount: Int): Array<List<Int>> {
        //val purchase = PurchaseAmount().enterNumber()
        var lottos = Array(purchaseAmount) { List(6) { 1 } }
        for (i in 0 until purchaseAmount) {
            lottos[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            //println(lottos[i])
        }
        return lottos
    }

    fun printLottos(lottos: Array<List<Int>>) {
        println("${lottos.size}개를 구입했습니다.")
        for (i in lottos.indices)
            println(lottos[i])
    }
}