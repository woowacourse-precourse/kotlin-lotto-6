package lotto
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    //TODO("프로그램 구현")
    println("lotto")
    //val data = readLine()
    //println("data:"+data)
    var lottonumber = picklotto()
    var guipmoney:Int
    var calloopnum:Int
    guipmoney = readLine()!!.toInt()
    calloopnum = guipmoney/1000
    println("guipmoney:"+guipmoney)
    println("calloopnum:"+calloopnum)
    for(item in lottonumber)
    {
        println(item)
    }
    val lotto = mutableListOf<Lotto>()
    while(calloopnum>0)
    {
        lotto.add(Lotto(lottonumber))
        calloopnum--
    }
    //lotto.add(Lotto(lottonumber))
    //lotto.add(Lotto(lottonumber))

    //lotto.add(Lotto(picklotto()))
    //lotto.add(Lotto(picklotto()))
    //lotto.add(Lotto(picklotto()))
    var num = 0
    for(item in lotto)
    {
        lotto[num].printdata()
        lotto[num].checkdangcheonm()
        lotto[num].checkdangcheonm2()
        println("=============")
        num++
    }



}

fun picklotto():List<Int>{
    var number= mutableListOf<Int>()
    var newnumber=0
    //var bonusnum=0
    var i=0
    while(i<6) {
        newnumber = pickNumberInRange(1, 45)

        println("number:" + newnumber)
        if(number.contains(newnumber))
        {
            continue
        }

        number.add(newnumber)
        println(""+(i+1)+"th number:"+newnumber)


        i++
    }
    return number
}

