package lotto

import camp.nextstep.edu.missionutils.Console

fun getPromptInput() = Console.readLine()
fun convertNumber(input:String) = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMsg.NOT_INT)
fun convertNumberList(input:String) = input
    .split(",")
    .map {
        it.toIntOrNull() ?: throw IllegalArgumentException(ErrorMsg.NOT_INT)
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
fun getAmount():Int{
    var amount:Int
    do {
        val input = getPromptInput()
        amount = catchErrorIntInput(input)
    }while(amount ==-1 && isPaymentValid(amount))
    return amount
}

fun getBonusNumber(lotto:Lotto):Int{
    var bonusNumber:Int
    do {
        bonusNumber = catchErrorIntInput()
        bonusNumber = catchErrorValidBonusNumber(bonusNumber,lotto)
    }while(bonusNumber == -1)
    return bonusNumber
}
fun getWinningNumber():Lotto
{
    var lotto:Lotto?
    do{
        val input = getPromptInput()
        lotto = catchErrorLotto(input)
    }while(lotto == null)
    return lotto
}


