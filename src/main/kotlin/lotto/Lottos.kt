package lotto


class Lottos {
    private val outputManager = OutputManager()
    fun makeLotto(lottoNum: Int): List<Lotto> {

        val numberCreator = NumberCreator()
        val lottos = mutableListOf<Lotto>()

        outputManager.printLottoNum(lottoNum)

        repeat(lottoNum) {
            val lottoNumber = numberCreator.randoms()
            outputManager.printLottos(lottoNumber.sorted())
            val lotto = Lotto(lottoNumber)
            lottos.add(lotto)
        }
        println()
        return lottos
    }
}