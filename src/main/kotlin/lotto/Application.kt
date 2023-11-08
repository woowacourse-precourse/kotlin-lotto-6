package lotto

fun main() {
    val lotto_tickets = buyLotto()
    print(lotto_tickets)
}

fun buyLotto(): Int {
    println("구입금액을 입력해 주세요.")
    val price = readLine()!!.toInt()
    if (price % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 로또 구매는 1000원 단위로만 가능합니다.")
    } else if (price == null) {
        throw IllegalArgumentException("[ERROR] 구입금액을 입력해주세요.")
    } else return price / 1000
}