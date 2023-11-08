package lotto

fun main() {
    val output = OutputView()
    val player = Player()
    val lottoMachine = LottoMachine()
    val lottoGame = LottoGame(output, player, lottoMachine)
    lottoGame.start()
}







