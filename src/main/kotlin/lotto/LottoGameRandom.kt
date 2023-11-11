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
    println("${repetition}개를 구매했습니다.")
    val ret = mutableListOf<Lotto>()
    repeat(repetition){
        ret.add(getMyLotto())
    }
    return ret
}