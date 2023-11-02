package lotto
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.Console.readLine
class Lotto(private val numbers: List<Int>) {
    var lottonumber= mutableListOf<Int>()
    var picknumber = mutableListOf<Int>()
    var bonusnumber:Int
    var containnumber:Int = 0
    var bonuscontain:Boolean = false
    var money:Int =0
    init {
        require(numbers.size == 6)
        lottonumber = numbers as MutableList<Int>
        picknumber = picklottoclass()
        bonusnumber = pickbonusclass()
    }

    fun printdata()
    {
        var i=1
        for(item in lottonumber)
        {
            println("lottodata"+i+"th:"+item)
            i++
        }
        i=1
        for(item in picknumber)
        {
            println("pickdata"+i+"th:"+item)
            i++
        }
        println("bonus"+bonusnumber)
    }
    // TODO: 추가 기능 구현
    fun picklottoclass():MutableList<Int>{
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
    fun pickbonusclass():Int {
        var bonus:Int

        do
        {
            bonus = pickNumberInRange(1,45)
            if(picknumber.contains(bonus))
            {
                continue
            }else{
                break
            }
        }while(true)
        return bonus

    }
    fun checkdangcheonm()
    {
        for(item in picknumber)
        {
            if(lottonumber.contains(item))
            {
                containnumber++
            }
        }

        if(lottonumber.contains(containnumber))
        {
            bonuscontain = true
        }
        println("당첨 숫자개수:"+containnumber)
        println("보너스"+bonuscontain)
    }

    fun checkdangcheonm2()
    {
        if(containnumber<3)
        {
            println("꽝")
        }else if(containnumber==3)
        {
            println("3개 일치 (5,000원)")
            money = 5000
        }else if(containnumber==4)
        {
            println("4개 일치 (50,000원)")
            money = 50000
        }else if(containnumber==5)
        {
            if(bonuscontain==true)
            {
                println("5개 일치, 보너스 볼 일치 (30,000,000원)")
                money = 30000000
            }else{
                println("5개 일치 (1,500,000원)")
                money = 1500000
            }

        }else if(containnumber==6)
        {
            println("6개 일치 (2,000,000,000원)")
            money = 2000000000
        }
    }

}
