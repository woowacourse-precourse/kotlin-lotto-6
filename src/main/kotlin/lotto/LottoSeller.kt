package lotto

class LottoSeller(private val lottoCount: Int) {
//랜덤수에 맞게 로또를 판매하는 곳, 돈을 받은 만큼 줬지?
    //what/who 계속 생각하기!
    //어떤 행위가 필요한가! 이 행위를 수행할 객체는 어디인가!

    fun generateLottoNumbers(): List<LottoGenerator> {
        //고객이 요구한 만큼 받아서 한번에 주는 거
        val result = mutableListOf<LottoGenerator>()
        repeat(lottoCount) {
            result.add(LottoGenerator())
        }
        return result
    }

}
