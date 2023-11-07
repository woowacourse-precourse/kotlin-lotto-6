package lotto

fun main() {
    val inputMoney =lottoMoneyInput()
}
fun lottoMoneyInput(): Int {
    println("구입금액을 입력해 주세요.")
    val inputMoney = readLine()!!.toInt()
    if (inputMoney % 1000 != 0) {
        throw IllegalArgumentException("1000원 단위로 입력해 주세요.")
    }
    return inputMoney
}
