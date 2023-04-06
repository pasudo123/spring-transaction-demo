package com.example.springtransactiondemo.demo01

import com.example.springtransactiondemo.model.Coffee
import com.example.springtransactiondemo.model.CoffeeRepository
import com.example.springtransactiondemo.model.Query
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Demo01ServiceWithRollback(
    private val coffeeRepository: CoffeeRepository
) {

    /**
     * ForceCommitException 은 예외가 발생해도 commit 이 됩니다.
     * 왜냐하면, Exception 클래스를 상속받은 UnCheckedException 이기 때문입니다.
     *
     * 그 외에는 모두 롤백됩니다. (RuntimeException, Error 를 상속받은 클래스들...)
     */
    @Transactional
    fun queryWithSize(query: Query, size: Int) {
        val coffees = (1..size).map {
            Coffee.random()
        }

        coffeeRepository.saveAll(coffees)
    }
}
