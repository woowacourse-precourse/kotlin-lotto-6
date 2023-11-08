package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        {
            "[ERROR] 6개의 숫자가 필요합니다."
        }

        require(numbers.toSet().size == 6)
        {
            "[ERROR] 중복된 숫자가 존재해서는 안됩니다."
        }

        numbers.forEach {
            require(it in 1..45)
            {
                "[ERROR] 1부터 45까지의 숫자만 사용가능합니다."
            }
        }
        numbers.sorted()
    }

    fun contains(element:Int) = numbers.contains(element)
    private fun getSetOfNumber() = numbers.toSet()
    private fun getPrize(lotto:Lotto,bonusNumber:Int):PRIZE
    {
        when(numbers.intersect(lotto.getSetOfNumber()).size)
        {
            3-> return PRIZE.FIFTH
            4-> return PRIZE.FOURTH
            5-> {
                if(numbers.minus(lotto.getSetOfNumber()).contains(bonusNumber))
                    return PRIZE.SECOND
                return PRIZE.THIRD
            }
            6-> return PRIZE.FIRST
            else-> return PRIZE.NONE
        }
    }
    fun getResult(lottos:List<Lotto>,bonusNumber: Int):Map<PRIZE,Int>
    {
        val result = mutableMapOf<PRIZE,Int>()
        for(lotto in lottos)
        {
            val prize = getPrize(lotto,bonusNumber)
            if(prize == PRIZE.NONE) continue
            result[prize] = result.getOrDefault(prize,0) + 1
        }
        for(prize in PRIZE.values())
        {
            if(prize == PRIZE.NONE) continue
            result[prize] = result.getOrDefault(prize,0)
        }
        return result
    }

    override fun toString() = numbers.toString()
}
enum class PRIZE{
    FIRST,SECOND,THIRD,FOURTH,FIFTH,NONE
}
