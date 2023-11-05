package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해 주세요.")
    val money = readLine()!!.toInt()
    val count = money / 1000
    println("${count}개를 구매했습니다.")

}