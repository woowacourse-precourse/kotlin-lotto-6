package lotto

fun pickLottoNumbers(): Lotto {
    val numbers = pickUniqueNumbersInRange(
        LottoConstraints.NUMBER_START, LottoConstraints.NUMBER_END, LottoConstraints.NUMBER_COUNT
    )
    return Lotto(numbers)
}

fun isValidInteger(digits:String):Boolean{
    return digits.all{it.isDigit()}
}

fun isPriceMultipleOf1000(value:Int):Boolean{
    return value % 1000 == 0
}

fun isPriceValid(digits:String):Boolean{
    if (!isValidInteger(digits)){
        return false
    }
    val value = digits.toInt()
    return isPriceMultipleOf1000(value)
}

fun lottoPayment():Int{
    var digits = Console.readLine()
    while (!isPriceValid(digits)){
        digits = Console.readLine()
    }
    return digits.toInt()
}

fun lottoGame(price:Int):List<Lotto>{
    val lottoGameTicketCount = price/1000
    println("${lottoGameTicketCount}개를 구매했습니다.")
    val tickets:List<Lotto> = listOf()
    repeat(lottoGameTicketCount){
        val ticket = pickLottoNumbers()
        println(ticket)
        tickets.add(ticket)
    }
    return tickets
}

fun main() {
    TODO("프로그램 구현")
}
