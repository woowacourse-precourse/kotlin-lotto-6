package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    TODO("프로그램 구현")
}

fun getUserMoney() {
    print("구입금액을 입력해 주세요.")
    val userInput = Console.readLine()

    return userInput
}
 
fun getLottoNumber() {
    print("당첨 번호를 입력해 주세요.")
    val userInput = Console.readline()

    return userInput
}

fun getBonusNumber() {
    print("보너스 번호를 입력해 주세요.")
    val userInput = Console.readline()

    return userInput
}

fun makeLottoNumber() {
    var lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
}