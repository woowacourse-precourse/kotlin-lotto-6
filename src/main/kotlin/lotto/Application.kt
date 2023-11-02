package lotto

import camp.nextstep.edu.missionutils.Console

const val PAYMENT_UNIT = 1000
fun main() {
    var amount = getPayment()

    while (amount != -1) {
        amount = getPayment()
    }

    val lotto = getLotto()
    while(true)
    {
        try {
            val bonusNumber = Console.readLine().toInt()
            if(isValidLuckyNumber(bonusNumber,lotto)) throw IllegalArgumentException("[ERROR] 유효하지 않은 보너스 번호입니다.")
        }catch (e:IllegalArgumentException)
        {
            continue
        }
        break
    }

    val myLottos = mutableListOf<Lotto>()
    repeat(amount / PAYMENT_UNIT)
    {
        myLottos.add(getLotto())
    }
    println("${amount / PAYMENT_UNIT}를 구매 했습니다.")
    myLottos.forEach{
        println(it)
    }
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
fun isValidLuckyNumber(bonusNumber:Int,lotto: Lotto) = lotto.contains(bonusNumber) && bonusNumber in 1..45