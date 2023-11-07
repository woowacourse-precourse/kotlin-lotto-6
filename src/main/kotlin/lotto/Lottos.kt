package lotto

class Lottos {
    private val vendor = Vendor()
    private val outputManager = OutputManager()
    private val lottoNum = vendor.lottoNum()
    fun makeLotto(): List<Lotto> {

        val numberCreator = NumberCreator()
        val lottos = mutableListOf<Lotto>()

        outputManager.lottos(lottoNum)

        repeat(lottoNum){
            val lottoNumber = numberCreator.randoms()
            println("${lottoNumber.sorted()}")
            val lotto = Lotto(lottoNumber)
            lottos.add(lotto)
        }
        println()
        return lottos
    }
}