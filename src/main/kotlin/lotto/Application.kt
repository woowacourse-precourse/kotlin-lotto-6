package lotto


fun main() {
    val lottoGame = LottoGame()
    // 기본생성자 호출로 로또게임 시작
    var playingFlag = true
    while (playingFlag) {
        LottoGame.requestMessage(LottoGame.buyPrice.toString())
        LottoGame.inputResult = LottoGame.userInput()
        println("입력값 : ${LottoGame.inputResult}")
        playingFlag = LottoGame.inputCheck(LottoGame.inputResult)
    }
    playingFlag = true
    LottoGame.inputResult.toInt()
    val lottoGameTimes = (LottoGame.inputResult.toInt() / 1000)
    while (playingFlag) {
        LottoGame.buyMessage((lottoGameTimes))
        playingFlag = false
    }
}


