package lotto

class Lottos {
    fun makeLotto(): List<Lotto> {
        val vendor = Vendor()
        val numberCreator = NumberCreator()
        val lottos = mutableListOf<Lotto>()

        repeat(vendor.lottoNum()){
            val lottoNumber = numberCreator.randoms()
            val lotto = Lotto(lottoNumber)
            lottos.add(lotto)
        }

        return lottos
    }
}