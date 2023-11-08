package lotto

import camp.nextstep.edu.missionutils.Randoms

fun createRandomNumberList() = Randoms.pickUniqueNumbersInRange(1, 45, 6)
fun getMyLotto():Lotto
{
    var lotto:Lotto?
    do{
        val input = createRandomNumberList()
        lotto = catchErrorLotto(input)
    }while(lotto == null)
    return lotto
}
fun getMyLottos(repetition:Int):List<Lotto>
{
    val ret = mutableListOf<Lotto>()
    repeat(repetition){
        ret.add(getMyLotto())
    }
    return ret
}