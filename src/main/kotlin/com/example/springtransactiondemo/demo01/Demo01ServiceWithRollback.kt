package com.example.springtransactiondemo.demo01

import com.example.springtransactiondemo.exception.CustomCheckedException
import com.example.springtransactiondemo.exception.SystemError
import com.example.springtransactiondemo.exception.SystemException
import com.example.springtransactiondemo.model.Coffee
import com.example.springtransactiondemo.model.CoffeeRepository
import com.example.springtransactiondemo.model.Query
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Demo01ServiceWithRollback(
    private val coffeeRepository: CoffeeRepository
) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * ForceCommitException 은 예외가 발생해도 commit 이 됩니다.
     * 왜냐하면, Exception 클래스를 상속받은 UnCheckedException 이기 때문입니다.
     *
     * 그 외에는 모두 롤백됩니다. (RuntimeException, Error 를 상속받은 클래스들...)
     */
    @Transactional(rollbackFor = [])
    fun queryWithSize(query: Query, size: Int) {
        val coffees = (1..size).map {
            Coffee.random()
        }

        coffeeRepository.saveAll(coffees)

        if (query == Query.Q_THROW_ERROR) {
            log.info("error 를 throw 한다. : 롤백처리")
            throw SystemError("$query 발생")
        }

        /**
         * @Transactional(rollbackFor = []) 설정이 필요하다.
         * 없으면 롤백이 되지 않는다.
         */
        if (query == Query.Q_THROW_EXCEPTION) {
            log.info("exception 을 throw 한다. : 명시적 롤백처리 필요")
            throw CustomCheckedException("$query 발생")
        }

        if (query == Query.Q_THROW_RUNTIME_EXCEPTION) {
            log.info("RuntimeException 을 throw 한다. : 롤백처리")
            throw SystemException("$query 발생")
        }
    }
}
