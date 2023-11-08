package lotto

import camp.nextstep.edu.missionutils.Console

fun getPromptInput() = Console.readLine()
fun convertNumber(input:String) = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMsg.NOT_INT)
fun catchErrorIntInput():Int
{
    var ret:Int
    try {
        val input = getPromptInput()
        ret = convertNumber(input)
    }catch (e:IllegalArgumentException)
    {
        print(e.message)
        ret = -1
    }
    return ret
}
fun getAmount():Int{
    var amount:Int
    do {
        amount = catchErrorIntInput()
    }while(amount ==-1 && isPaymentValid(amount))
    return amount
}


