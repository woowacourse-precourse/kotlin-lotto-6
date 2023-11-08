package lotto.model.validator

interface Validator<T> {

    fun validate(data: T)
}