package lotto

import camp.nextstep.edu.missionutils.Console

fun getPromptInput() = Console.readLine()
fun convertNumber(input:String) = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMsg.NOT_INT)
fun convertNumberList(input:String) = input
    .split(",")
    .map {
        it.toIntOrNull() ?: throw IllegalArgumentException(ErrorMsg.NOT_INT)
    }

fun getAmount():Int{
    println(GuideMsg.AMOUNT_MSG)
    var amount:Int
    do {
        val input = getPromptInput()
        amount = catchErrorIntInput(input)
    }while(amount ==-1 && isPaymentValid(amount))
    return amount
}

fun getBonusNumber(lotto:Lotto):Int{
    println(GuideMsg.BONUS_MSG)
    var bonusNumber:Int
    do {
        val input = getPromptInput()
        bonusNumber = catchErrorIntInput(input)
        bonusNumber = catchErrorValidBonusNumber(bonusNumber,lotto)
    }while(bonusNumber == -1)
    return bonusNumber
}
fun getWinningNumber():Lotto
{
    println(GuideMsg.WINNING_MSG)
    var lotto:Lotto?
    do{
        val input = getPromptInput()
        lotto = catchErrorLotto(input)
    }while(lotto == null)
    return lotto
}


