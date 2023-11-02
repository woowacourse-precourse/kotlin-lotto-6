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
        //lottoList[i] 로또번호 리스트 출력
    }
}
