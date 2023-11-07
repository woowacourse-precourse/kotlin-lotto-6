package lotto.domain

import lotto.data.LottoNums

class LottoManager {

    private var lottoNums = LottoNums(emptyList(),0)
    val split = ","

    init {
        lottoNums.lottoNums = inputToInt()
        lottoNums.bonusNum = bonusToInt()

    }

    private fun inputToInt() : List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val inputLottoNums = readLine()
        if (!checkInputLottoNums(inputLottoNums)) return inputToInt()

        val nums = inputLottoNums?.split(split)
        var checkNum: Int?
        val numsList = mutableListOf<Int>()

        nums?.forEach { num ->
            checkNum = num.toInt()
            numsList.add(checkNum!!)
        }
        if (!checkDuplicateNums(numsList)) return inputToInt()

        return numsList
    }
    private fun checkInputLottoNums(inputLottoNums: String?) : Boolean {

        return try {
            val nums = inputLottoNums?.split(split)
            var checkNum : Int?

            nums?.forEach {
                num ->
                checkNum = num.toIntOrNull()
                if(checkNum ==null || checkNum!! < 1 || checkNum!! > 45) throw java.lang.IllegalArgumentException()
            }
            if(nums?.size!=6) throw IllegalArgumentException()

            true
        }catch (e : IllegalArgumentException){
            println("[ERROR] 로또 번호는 1부터 45 사이의 6가지 숫자여야 합니다.")
            false
        }

    }

    private fun checkDuplicateNums(nums : List<Int>) : Boolean{

        return try{
            if(nums.distinct().size != 6) throw IllegalArgumentException()
            true
        }catch (e : IllegalArgumentException){
            println("[ERROR] 로또 번호는 중복 될 수 없습니다.")
            false
        }
    }

    private fun bonusToInt() : Int{
        println("보너스 번호를 입력해주세요")
        val bonus = readLine()
        if(!checkBonusNums(bonus) || !checkBonusDuplicated(bonus!!.toInt())) return bonusToInt()

        return bonus.toInt()
    }

    private fun checkBonusNums(bonusNum : String?) : Boolean {
        return try {
            val num = bonusNum?.toIntOrNull()
            if(num == null || num < 1 || num > 45) throw IllegalArgumentException()

            true
        }catch (e: IllegalArgumentException){
            println("[ERROR] 로또 번호는 1부터 45 사이의 6가지 숫자여야 합니다.")
            false
        }

    }


    private fun checkBonusDuplicated(bonusNum: Int?) : Boolean {
        return try {
            if(lottoNums.lottoNums.contains(bonusNum))throw IllegalArgumentException()
            true
        }catch (e: IllegalArgumentException){
            println("[ERROR] 로또 번호는 중복 될 수 없습니다.")
            false
        }
    }



}