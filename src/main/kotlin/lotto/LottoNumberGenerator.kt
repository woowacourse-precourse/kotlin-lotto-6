package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoNumberGenerator : NumberGenerator {
    //랜덤로또생성 후 제대로 된 로또 한장을 만들어 내는

    override fun generate(): List<Int> {
        //제대로 된 로또 내놔!에 대한 응답임
        val randomLottoNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_NUMBER)
        //제대로된 로또 주려면 중복체크 해야되고 정렬해서 줘야 되자넝!
        return checkRandomLottoNumber(randomLottoNumber)
    }

    private fun checkRandomLottoNumber(randomNum: List<Int>): List<Int> {
//나 중복체크 할 수 있어!!
        if (randomNum.distinct().size > 6) generate()
        return isSortedLottoNumber(randomNum)
    }

    private fun isSortedLottoNumber(randomNum: List<Int>): List<Int> {
        //중복체크는 되어 있는거니까 정렬해서 보내주자!
        return randomNum.sorted()
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val PICK_NUMBER = 6
    }
}
