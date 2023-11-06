package lotto

class LottoMaker() {

    fun makeLottoTickets(amount: Int):List<Lotto> {

        val times = amount / 1000
        val myTickets = mutableListOf<Lotto>()
        val generator = RandomNumbersGenerator()
        repeat(times) {
            val numbers = generator.makeRandomNumbers()
            myTickets.add(Lotto(numbers))
        }
        return myTickets
    }
}