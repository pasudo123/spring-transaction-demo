package com.example.springtransactiondemo.demo01

import com.example.springtransactiondemo.model.Query
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("demo01")
class Demo01Controller(
    private val demo01PropagationService: Demo01PropagationService,
    private val demo01ServiceWithRollback: Demo01ServiceWithRollback
) {

    @GetMapping
    fun createCoffeeOrException(
        @RequestParam(name = "query") query: Query,
        @RequestParam(name = "size", required = false) size: Int = 5
    ) {
        demo01ServiceWithRollback.queryWithSize(query, size)
    }

    @GetMapping("with-event")
    fun createCoffeeAndEvent(
        @RequestParam("flag") flag: Boolean
    ) {
        demo01PropagationService.createCoffeeWithEvent(flag)
    }
}
