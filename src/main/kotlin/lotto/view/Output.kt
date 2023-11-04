package lotto.view

class Output {
    enum class GuideMessage(
        val message: String
    ) {
        AskPurchaseAmount("구입금액을 입력해 주세요."),
        AskWinningLottoNumber("당첨 번호를 입력해 주세요."),
        AskBonusNumber("보너스 번호를 입력해 주세요."),
    }

}