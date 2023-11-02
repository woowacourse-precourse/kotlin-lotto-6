package lotto

import camp.nextstep.edu.missionutils.Console

const val PAYMENT_UNIT = 1000
fun main() {
    var amount = getPayment()

    while (amount != -1) {
        amount = getPayment()
    }

    val lotto = getLotto()
}
fun isPaymentValid(amount:Int) = (amount % PAYMENT_UNIT) == 0
fun getPayment():Int
{
    var amount:Int
    try {
        amount = Console.readLine().toInt()
        if(!isPaymentValid(amount)) throw IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.")
    }catch (e:IllegalArgumentException)
    {
        return -1
    }
    return amount
}
fun getLotto(): Lotto {
    var lotto:Lotto
    while(true)
    {
        try {
            lotto = Lotto(Console.readLine()
                .split(",")
                .map { it.toInt() })
        }catch (e:IllegalArgumentException) {
            continue
        }
        break
    }
    return lotto
}