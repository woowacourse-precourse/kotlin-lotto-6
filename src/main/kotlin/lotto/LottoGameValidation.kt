package lotto

fun isPaymentValid(amount:Int) = (amount % PAYMENT_UNIT) == 0
fun isDuplicatedNumber(bonusNumber:Int,lotto: Lotto){
    if(lotto.contains(bonusNumber))
        throw IllegalArgumentException(ErrorMsg.DUPLICATED)
}
fun isOutOfRangeNumber(bonusNumber: Int)
{
    if(bonusNumber !in 1..45)
        throw IllegalArgumentException(ErrorMsg.OUT_OF_RANGE)
}

fun catchErrorIntInput(input: String):Int
{
    var ret:Int
    try {
        ret = convertNumber(input)
    }catch (e:IllegalArgumentException)
    {
        print(e.message)
        ret = -1
    }
    return ret
}
fun catchErrorValidBonusNumber(input:Int,lotto: Lotto):Int
{
    var ret = input
    try {
        isDuplicatedNumber(bonusNumber = ret, lotto = lotto)
        isOutOfRangeNumber(bonusNumber = ret)
    }catch (e:IllegalArgumentException)
    {
        print(e.message)
        ret = -1
    }
    return ret
}

fun catchErrorLotto(input:String): Lotto?
{
    try {
        return Lotto(convertNumberList(input))
    }catch (e:IllegalArgumentException)
    {
        print(e.message)
        return null
    }
}