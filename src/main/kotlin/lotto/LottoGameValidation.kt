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