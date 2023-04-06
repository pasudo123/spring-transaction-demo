package com.example.springtransactiondemo.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoffeeRepository : JpaRepository<Coffee, Long>
