package lotto.domain

class Validator private constructor(){
    fun checkInputOfPurchasingCorrect(input: String): Boolean {
        val number = input.toUIntOrNull()
        return number != null && number > 0u
    }

    companion object {
        private var instance: Validator? = null
        fun getInstance(): Validator {
            val validator = instance
            if (validator != null) {
                return validator
            }
            return synchronized(this) {
                val validatorForCheck = instance
                if (validatorForCheck != null) {
                    return@synchronized validatorForCheck
                }
                val createdValidator = Validator()
                instance = createdValidator
                createdValidator
            }
        }

        fun releaseInstance() {
            instance = null
        }
    }
}