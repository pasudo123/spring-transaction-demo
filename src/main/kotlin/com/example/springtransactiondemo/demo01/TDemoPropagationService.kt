package com.example.springtransactiondemo.demo01

import com.example.springtransactiondemo.exception.SystemException
import com.example.springtransactiondemo.model.Coffee
import com.example.springtransactiondemo.model.CoffeeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TDemoPropagationService(
    private val coffeeRepository: CoffeeRepository
) {

    /**
     * alim_event 는 저장하고 싶다. 근데 저장이 안되네?
     */
    @Transactional
    fun createCoffeeWithEvent(flag: Boolean) {
        try {
            coffeeRepository.save(Coffee.random())
            // tDemoPropagationInnerService.createAlimEvent(AlimEvent.fromWithSuccess())

            // false
            if (flag.not()) {
                throw SystemException("익셉션이 발생했다.")
            }
        } catch (exception: Exception) {
            // tDemoPropagationInnerService.createAlimEvent(AlimEvent.fromWithFailed())
            throw exception
        }
    }
}
