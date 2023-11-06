package lotto

class Lottos {
    fun makeLotto(): List<Lotto> {
        val vendor = Vendor()
        val numberCreator = NumberCreator()
        val lottos = mutableListOf<Lotto>()

        repeat(vendor.lottoNum()){
            val lotto = Lotto(numberCreator.randoms())
            lottos.add(lotto)
        }

        return lottos
    }
}