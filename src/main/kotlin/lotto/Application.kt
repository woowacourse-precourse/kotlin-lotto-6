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

fun main() {
    TODO("프로그램 구현")
}
