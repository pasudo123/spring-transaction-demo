package com.example.springtransactiondemo.exception

/**
 * RuntimeException 은 UnCheckedException
 */
open class SystemException(
    override val message: String
) : RuntimeException(message)

/**
 * Error 는 UnCheckedException
 */
open class SystemError(
    override val message: String
) : Error(message)

/**
 * Exception 은 CheckedException
 */
open class CustomCheckedException(
    override val message: String
) : Exception(message)
