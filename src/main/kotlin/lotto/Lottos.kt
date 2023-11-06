package lotto

class Lottos {
    fun makeLotto(): List<Lotto> {
        val vendor = Vendor()
        val outputManager = OutputManager()
        val numberCreator = NumberCreator()
        val lottos = mutableListOf<Lotto>()
        val lottoNum = vendor.lottoNum()

        outputManager.lottos(lottoNum)

        repeat(lottoNum){
            val lottoNumber = numberCreator.randoms()
            println("$lottoNumber")
            val lotto = Lotto(lottoNumber)
            lottos.add(lotto)
        }

        return lottos
    }
}