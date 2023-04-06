package com.example.springtransactiondemo.model

enum class Query(val desc: String) {

    Q_SUCCESS("성공"),
    Q_THROW_RUNTIME_EXCEPTION("RuntimeException 을 Throw 한다"),
    Q_THROW_EXCEPTION("Exception 을 Throw 한다"),
    Q_THROW_ERROR("Error 를 Throw 한다.")
}
