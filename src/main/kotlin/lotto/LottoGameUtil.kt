package lotto

fun getStringMoney(prize: PRIZE):String
{
    when(prize)
    {
        PRIZE.FIFTH -> return "3개 일치 (5,000원)"
        PRIZE.FOURTH -> return "4개 일치 (50,000원)"
        PRIZE.THIRD -> return "5개 일치 (1,500,000원)"
        PRIZE.SECOND -> return "5개 일치, 보너스 볼 일치 (30,000,000원)"
        PRIZE.FIRST -> return "6개 일치 (2,000,000,000원)"
        PRIZE.NONE -> return "0"
    }
}
fun getIntMoney(prize: PRIZE):Int
{
    when(prize)
    {
        PRIZE.FIFTH -> return 5000
        PRIZE.FOURTH -> return 50000
        PRIZE.THIRD -> return 1500000
        PRIZE.SECOND -> return 30000000
        PRIZE.FIRST -> return 2000000000
        PRIZE.NONE -> return 0
    }
}